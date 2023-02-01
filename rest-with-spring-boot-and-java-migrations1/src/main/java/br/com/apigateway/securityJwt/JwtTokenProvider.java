package br.com.apigateway.securityJwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;

import br.com.apigateway.data.vo.v1.security.TokenVO;
import jakarta.annotation.PostConstruct;

@Service
public class JwtTokenProvider {

	@Value("${jwt.secret:secret}")
	private String secretKey = "secret";
	
	@Value("${jwt.refreshExpirationDateInMs}")
	private long validityInMilliseconds = 3600000;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	Algorithm algorithm = null;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}
	
	public TokenVO createAccessToken(String username, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime()+validityInMilliseconds);
		var accessToken = getAcessToken(username,roles,now,validity);
		var refreshToken = getAcessToken(username,roles,now);
		return new TokenVO(username,true,now,validity,accessToken,refreshToken);
	}

	private String getAcessToken(String username, List<String> roles, Date now) {
		
		return null;
	}

	private String getAcessToken(String username, List<String> roles, Date now, Date validity) {
		
		return null;
	}
	
}
