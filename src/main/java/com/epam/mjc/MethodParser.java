package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        StringSplitter splitter = new StringSplitter();
        List<String> delimiters = new ArrayList<>();
        delimiters.add("(");
        delimiters.add(")");
        List<String> parsedFunction = splitter.splitByDelimiters(signatureString, delimiters);

        for (String s :
                parsedFunction) {
            System.out.println("parsed function" + s);
        }

        String accessModifier = "";
        String returnType = "";
        String functionName = "";

        delimiters.add(" ");
        List<String> function = splitter.splitByDelimiters(parsedFunction.get(0), delimiters);

        for (String s :
                function) {
            System.out.println("function" + s);
        }

        if (function.size() == 3) {
            accessModifier = function.get(0);
            returnType = function.get(1);
            functionName = function.get(2);

        }

        if (function.size() == 2) {
            returnType = function.get(0);
            functionName = function.get(1);
        }


        List<MethodSignature.Argument> argumentList = new ArrayList<>();

        delimiters.add(", ");

        if (parsedFunction.size() == 2) {
            List<String> argumentString = splitter.splitByDelimiters(parsedFunction.get(1), delimiters);

            for (String s :
                    argumentString) {
                System.out.println("argumentString" + s);
            }
            for (int i = 0; i < argumentString.size() - 1; i = i + 2) {
                MethodSignature.Argument argument = new MethodSignature.Argument(argumentString.get(i), argumentString.get(i + 1));
                argumentList.add(argument);
            }
        }


        MethodSignature methodSignature = new MethodSignature(functionName, argumentList);
        methodSignature.setReturnType(returnType);
        if (!accessModifier.isBlank()) {
            methodSignature.setAccessModifier(accessModifier);
        }

        return methodSignature;
    }
}
