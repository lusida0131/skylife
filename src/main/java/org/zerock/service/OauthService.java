package org.zerock.service;

import org.zerock.oauth.helper.constants.SocialLoginType;
import org.zerock.oauth.service.social.SocialOauth;

public interface OauthService {
	 public void request(SocialLoginType socialLoginType);
	public String requestAccessToken(SocialLoginType socialLoginType, String code);
	public SocialOauth findSocialOauthByType(SocialLoginType socialLoginType);

}
