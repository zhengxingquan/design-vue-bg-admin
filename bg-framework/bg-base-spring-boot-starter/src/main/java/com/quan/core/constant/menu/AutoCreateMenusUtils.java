//package com.quan.core.common.menu;
//
//
//import com.quan.core.common.model.SysMenu;
//
//import java.lang.reflect.Method;
//import java.sql.Timestamp;
//import java.text.Collator;
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * @author liujianguo
// * @data 2020/1/2
// * 描述：
// */
//public class AutoCreateMenusUtils {
//
//    private final static Comparator CHINA_COMPARE;
//    private static List<SysMenu> menuList = new ArrayList<>();
//
//    static {
//        CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);
//    }
//
//    public static List<SysMenu> scanPackage(String scanPackage, List<SysMenu> systemMenus) {
//        List<SysMenu> menus = new ArrayList<>();
//        List<Class<?>> classList = Scans.me().scanPackage(scanPackage);
//        classList.stream().filter(aClass -> aClass.getAnnotation(At.class) != null).forEach(aClass -> scanClass(aClass));
//        Collections.sort(menuList, (o1, o2) -> CHINA_COMPARE.compare(o1.getName(), o2.getName()));
//        systemMenus.forEach(sysMenu -> {
//            menus.addAll(createTree(menuList, sysMenu.getPermission()));
//        });
//
//        return menus;
//    }
//
//    /**
//     * 迭代权限树
//     *
//     * @param menus
//     * @param parentPermission
//     * @return
//     */
//    private static List<SysMenu> createTree(List<SysMenu> menus, String parentPermission) {
//        List<SysMenu> childList = new ArrayList<>();
//        for (SysMenu c : menus) {
//            String permission = c.getPermission();
//            String pid = c.getParentPermission();
//            if (parentPermission.equals(pid)) {
//                List<SysMenu> childs = createTree(menus, permission);
//                c.setChildren(childs);
//                childList.add(c);
//            }
//        }
//        return childList;
//    }
//
//
//    private static void scanClass(Class<?> klass) {
//        Method[] methods = klass.getMethods();
//        String classAtPath = getAtPath(klass.getAnnotation(At.class), klass, null);
//        for (Method method : methods) {
//            AutoCreateMenuAuth autoCreateMenuAuth = method.getAnnotation(AutoCreateMenuAuth.class);
//            RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
//            At methodAt = method.getAnnotation(At.class);
//            if (autoCreateMenuAuth == null) {
//                continue;
//            }
//            if (autoCreateMenuAuth != null && requiresPermissions == null) {
//                throw new RuntimeException(MessageFormat.format("{0} 请设置@RequiresPermissions", method.toGenericString()));
//            }
//            SysMenu menu = new SysMenu();
//            menu.setName(autoCreateMenuAuth.name());
//            if(autoCreateMenuAuth.type().equals(MenuType.MENU)){
//                menu.setHref(classAtPath + getAtPath(methodAt, null, method));
//                menu.setAliasName(getMenuAliasName(classAtPath));
//                menu.setTarget(null);
//                menu.setMenuIcon(autoCreateMenuAuth.icon());
//            }else{
//                menu.setMenuIcon(null);
//                menu.setTarget(autoCreateMenuAuth.target());
//                menu.setAliasName(getMenuAliasName(classAtPath + getAtPath(methodAt, null, method)));
//            }
//            menu.setType(autoCreateMenuAuth.type().name());
//            menu.setDelFlag(false);
//            menu.setDisabled(false);
//            menu.setSort(autoCreateMenuAuth.shortNo());
//            menu.setNote(Strings.isNotBlank(autoCreateMenuAuth.note()) ? autoCreateMenuAuth.note() : menu.getName());
//            menu.setPermission(requiresPermissions.value()[0]);
//            menu.setParentPermission(autoCreateMenuAuth.parentPermission());
//            menu.setOpTime(new Timestamp(System.currentTimeMillis()));
//            menuList.add(menu);
//        }
//    }
//
//    private static String getAtPath(At at, Class<?> klass, Method method) {
//        if (at == null || at.value().length == 0) {
//            if (klass == null) {
//                return Strings.lowerFirst(method.getName());
//            } else {
//                return Strings.lowerFirst(klass.getSimpleName());
//            }
//        } else {
//            return at.value()[0];
//        }
//    }
//
//    private static String getMenuAliasName(String classAtPath) {
//        if (Strings.isNotBlank(classAtPath)) {
//            String[] names = classAtPath.split("\\/");
//            int length = names.length - 1;
//            String aliasName = "";
//            do {
//                aliasName = names[length];
//                length--;
//            } while (length >= 0 && "?".equals(aliasName));
//            return Strings.upperFirst(aliasName);
//        }
//        return null;
//    }
//}
