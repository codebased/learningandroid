package tests.templates;

import org.junit.Test;

import java.util.ArrayList;

import generics.TemplateTypeBound;

/**
 * Created by codebased on 23/07/16.
 */
public class TemplateTypeBoundTests {


    @Test
    public void test() {
        TemplateTypeBound<ArrayList<String>> type = new TemplateTypeBound<>(new ArrayList<String>());

    }
}
