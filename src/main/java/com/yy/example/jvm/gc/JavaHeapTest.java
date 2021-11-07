package com.yy.example.jvm.gc;

/**
 * Description: 使用VisualVM工具进行jvm性能调优
 * <p></p>
 * <pre>
 *     注意：main方法debug时VisualVM工具不起作用
 *
 *     refer to:
 *     https://www.cnblogs.com/wade-xu/p/4369094.html
 *     https://blog.belonk.com/blog/c/%E4%BD%BF%E7%94%A8visualvm%E7%9B%91%E6%8E%A7Java%E7%A8%8B%E5%BA%8F%E6%80%A7%E8%83%BD%E4%BA%8C%E4%B8%BB%E7%AA%97%E5%8F%A3%E5%8A%9F%E8%83%BD%E8%AF%A6%E8%A7%A3.html
 * </pre>
 * NB.
 * Created by skyler on 2018/5/22 at 下午6:36
 */
public class JavaHeapTest {
    public final static int OUTOFMEMORY = 200000000;

    private final String oom;

    private final int length;

    StringBuffer tempOOM = new StringBuffer();

    public JavaHeapTest(final int leng) {
        this.length = leng;

        int i = 0;
        while (i < leng) {
            i++;
            try {
                if (leng == 20000) {
                    Thread.sleep(1000 * 60 * 5);
                }
                tempOOM.append("a");
            } catch (final OutOfMemoryError e) {
                e.printStackTrace();
                break;
            } catch (final Exception e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(final String[] args) {
        final JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }
}
