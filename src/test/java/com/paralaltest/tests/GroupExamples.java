package com.paralaltest.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    public class GroupExamples {
        @Parameters({"browser", "baseurl"})
        @Test(groups = "parametre")
        public void parametersTest(String browser, String baseurl){
            System.out.println(browser);
            System.out.println(baseurl);
        }
        @Test(groups = {"meyve, elma"})
        public void groupExamTest01(){
            System.out.println("grup örnek test elma");
        }
        @Test(groups = {"meyve"})
        public void groupExamTest05(){
            System.out.println("grup örnek test armut");
        }
        @Test(groups = "sebze")
        public void groupExamTest02(){
            System.out.println("grup örnek test havuç");
        }
        @Test(groups = "sebze")
        public void groupExamTest06(){
            System.out.println("grup örnek test kabak");
        }
        @Test(groups = "tek", priority = 1)
        public void groupExamTest03(){
            System.out.println("grup örnek test 3");
        }
        @Test(groups = "çift")
        public void groupExamTest04(){
            System.out.println("grup örnek test 4");
        }
}
