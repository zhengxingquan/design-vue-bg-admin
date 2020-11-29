//package com.quan.core;
//
//import java.util.List;
//
///**
// * @author 郑兴泉 956607644@qq.com
// * @data 2020/11/18
// * 描述：
// */
//public class PaginationPlugin extends PluginAdapter {
//
//    /**
//     * Validate boolean.
//     *
//     * @param warnings the warnings
//     *
//     * @return the boolean
//     */
//    @Override
//    public boolean validate(List<String> warnings) {
//        return true;
//    }
//
//
//    private static void generate() {
//        String config = PaginationPlugin.class.getClassLoader().getResource("generator/generatorConfig-B.xml").getFile();
//        String[] arg = {"-configfile", config, "-overwrite"};
//        ShellRunner.main(arg);
//    }
//
//    public static void main(String[] args) {
//        generate();
//    }
//}