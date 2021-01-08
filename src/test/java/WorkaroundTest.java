package com.mypackage;

import static org.junit.Assert.*;
import org.junit.Test;

public class WorkaroundTest {
    @Test
    public void testsForSquareBracketsOnly() {
        assertEquals(Workaround.replacebuilder("[][]"), "{}{}");
        assertEquals(Workaround.replacebuilder("[["), "[[");
        assertEquals(Workaround.replacebuilder("]["), "][");
    }

    @Test
    public void testsForSlashn() {
        assertEquals(Workaround.replacebuilder("\n\n\n"), "");
        assertEquals(Workaround.replacebuilder("\n\t"), "\t");
        assertEquals(Workaround.replacebuilder("\n\r\t\n"), "\r\t");
    }

    @Test
    public void testsForQuotes() {
        assertEquals(Workaround.replacebuilder("\"\"\'"), "\'\'\'");
        assertEquals(Workaround.replacebuilder("\"\t"), "\'\t");
        assertEquals(Workaround.replacebuilder("\'"), "\'");
    }

    @Test
    public void testsAll() {
        assertEquals(Workaround.replacebuilder("\"\n[]"), "\'{}");
        assertEquals(Workaround.replacebuilder("[][]\"\""), "{}{}\'\'");
        assertEquals(Workaround.replacebuilder("\n\n[]\"\""), "{}\'\'");
    }

}
