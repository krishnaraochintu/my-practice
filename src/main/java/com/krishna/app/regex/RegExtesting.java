package com.krishna.app.regex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExtesting {
    private static final String ARTIFACT_PROJECT_ID_REGEX =
            "(/studio/services/)(projectShells\\/|themes\\/|prefabs\\/|templatebundles\\/)(WM([^\\/]+))(.*?)";
    private static final Pattern ARTIFACT_PROJECT_ID_PATTERN = Pattern.compile(ARTIFACT_PROJECT_ID_REGEX);

    public static void main(String[] args) {
        List<String> parameters = new ArrayList<String>();
        String message = "Unexpected error {0}, ,please check server logs for more information";
        parameters.add("http://gitlab.wavemaker-qa.com/wavemaker-dev/NewVCStester.git: cannot open git-upload-pack");
        if(message.contains("{0}")) {
            String format = MessageFormat.format(message, parameters);
            System.out.println(format);
        }

        /*String reqUriNice = "/studio/services/prefabs/WMPRJ2c91808c7b0dd213017b0dda0d8b0004/publish/testing";
        String reqUriWrong = "/studio/services/prefabs?projectID=WMPRJ2c91808c7b0b727c017b0d1670160ad1/publish";
        Matcher reqUriNiceMatcher = ARTIFACT_PROJECT_ID_PATTERN.matcher(reqUriNice);
        Matcher reqUriWrongMatcher = ARTIFACT_PROJECT_ID_PATTERN.matcher(reqUriWrong);
        System.out.println(reqUriNiceMatcher.matches());
        System.out.println(reqUriWrongMatcher.matches());
        if (reqUriNiceMatcher.matches()) {
            //get projectId from request
            System.out.println("0:"+reqUriNiceMatcher.group(0));
            System.out.println("1:"+reqUriNiceMatcher.group(1));
            System.out.println("2:"+reqUriNiceMatcher.group(2));
            System.out.println("3:"+reqUriNiceMatcher.group(3));
            System.out.println("4:"+reqUriNiceMatcher.group(4));
            System.out.println("5:"+reqUriNiceMatcher.group(5));
        }*/
    }
}
