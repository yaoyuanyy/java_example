package com.yy.example.pattern_mode.structure.composite.security;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 10:52
 */
public class MenuClient {

    public static void main(String[] args) {
        Catalog root = new Catalog("skyler管理后台", 1);
        Catalog second1 = new Catalog("人员", 2);
        Catalog second2 = new Catalog("地区", 2);
        Content thrid1 = new Content("教学人员", 3);

        Catalog thrid2 = new Catalog("东北", 3);
        Content thrid3 = new Content("华南", 3);

        Content fouth = new Content("黑龙江", 4);

        root.add(second1);
        root.add(second2);

        second1.add(thrid1);

        second2.add(thrid2);
        second2.add(thrid3);

        thrid2.add(fouth);

        root.print();
    }
}
