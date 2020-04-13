package com.nox.player.appcenter.en.util.apiVersionControl;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("/v(\\d+(\\.\\d+)?).*");

    private double apiVersion;

    ApiVersionCondition(double apiVersion) {
        this.apiVersion = apiVersion;
    }

    public double getApiVersion() {
        return apiVersion;
    }


    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (m.find()) {
            Double version = Double.valueOf(m.group(1));
            if (version >= this.apiVersion) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        int compare;
        double flag=apiVersionCondition.getApiVersion() - this.apiVersion;
        if(flag>0){
            compare=1;
        }else if(flag==0){
            compare=0;
        }else{
            compare=-1;
        }
        return compare;
    }

}
