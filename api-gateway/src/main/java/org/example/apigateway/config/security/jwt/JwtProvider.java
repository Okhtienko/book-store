package org.example.apigateway.config.security.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.apigateway.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtProvider {

	@Value("${security.secret}")
	private String jwtSecret;

	@Value("${security.session-duration-minutes}")
	private Long sessionDurationMinutes;

	@Value("${security.refresh}")
	private String jwtRefreshSecret;

	@Value("${security.refresh-duration-minutes}")
	private Long refreshSessionDurationMinutes;

	public String generateAccessToken(final User user) {
		final Date date = generateDate(sessionDurationMinutes);
		return Jwts.builder()
					.setSubject(user.getUsername())
					.setExpiration(date)
					.signWith(SignatureAlgorithm.HS512, jwtSecret)
					.claim("roles", user.getRoles())
					.claim("email", user.getEmail())
					.compact();
	}

	public String generateRefreshToken(final User user) {
		final Date date = generateDate(refreshSessionDurationMinutes);
		return Jwts.builder()
					.setSubject(user.getUsername())
					.setExpiration(date)
					.signWith(SignatureAlgorithm.HS512, jwtRefreshSecret)
					.compact();
	}

	private Date generateDate(final Long durationMinutes) {
		final Instant instant = LocalDateTime.now()
					.plus(Duration.ofMinutes(durationMinutes))
					.toInstant(ZoneOffset.UTC);
		return Date.from(instant);
	}

	public boolean validateAccessToken(final String accessToken) {
		return validateToken(accessToken, jwtSecret);
	}

	public boolean validateRefreshToken(final String refreshToken) {
		return validateToken(refreshToken, jwtRefreshSecret);
	}

	private boolean validateToken(final String token, final String secret) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException expEx) {
			log.info("Token expired");
		} catch (UnsupportedJwtException unsEx) {
			log.info("Unsupported jwt");
		} catch (MalformedJwtException mjEx) {
			log.info("Malformed jwt");
		} catch (SignatureException sEx) {
			log.info("Invalid signature");
		} catch (Exception e) {
			log.info("invalid token");
		}
		return false;
	}

	public Claims getAccessTokenClaims(final String accessToken) {
		return getTokenClaims(accessToken, jwtSecret);
	}

	public Claims getRefreshTokenClaims(final String refreshToken) {
		return getTokenClaims(refreshToken, jwtRefreshSecret);
	}

	private Claims getTokenClaims(final String token, final String secret) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

}
