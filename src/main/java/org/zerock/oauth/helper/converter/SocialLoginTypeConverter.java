package org.zerock.oauth.helper.converter;

import org.springframework.context.annotation.Configuration;
import org.zerock.oauth.helper.constants.SocialLoginType;

import com.google.protobuf.Internal.ListAdapter.Converter;

@Configuration
public class SocialLoginTypeConverter implements Converter<String, SocialLoginType> {
    @Override
    public SocialLoginType convert(String s) {
        return SocialLoginType.valueOf(s.toUpperCase());
    }
}
