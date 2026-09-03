package com.alibaba.fastjson2.issues_7800;

import com.alibaba.fastjson2.util.TypeUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("regression")
public class Issue7842 {
    @Test
    public void testTrueSpellings() {
        for (String s : new String[]{"true", "TRUE", "True", "T", "t", "Y", "y"}) {
            assertTrue(TypeUtils.cast(s, Boolean.class), s);
        }
    }

    @Test
    public void testFalseSpellings() {
        for (String s : new String[]{"false", "FALSE", "False", "0", "F", "f", "N", "n"}) {
            assertFalse(TypeUtils.cast(s, Boolean.class), s);
        }
    }

    @Test
    public void testLenientFallback() {
        assertFalse(TypeUtils.cast("abc", Boolean.class));
        assertFalse(TypeUtils.cast("2", Boolean.class));
        assertFalse(TypeUtils.cast("YES", Boolean.class));
        // "1" stays false: pinned by JSONObjectTest.test_invoke, do not change it here
        assertFalse(TypeUtils.cast("1", Boolean.class));
        assertNull(TypeUtils.cast("", Boolean.class));
        assertNull(TypeUtils.cast("null", Boolean.class));
        assertNull(TypeUtils.cast(null, Boolean.class));
    }

    @Test
    public void testPrimitive() {
        assertEquals(Boolean.TRUE, TypeUtils.cast("TRUE", boolean.class));
        assertEquals(Boolean.FALSE, TypeUtils.cast("1", boolean.class));
        assertEquals(Boolean.FALSE, TypeUtils.cast("FALSE", boolean.class));
        assertEquals(Boolean.FALSE, TypeUtils.cast("abc", boolean.class));
        assertEquals(Boolean.FALSE, TypeUtils.cast("", boolean.class));
    }
}
