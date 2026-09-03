package com.alibaba.fastjson2.issues_7800;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("regression")
@Tag("annotation")
@Tag("compat-jackson")
public class Issue7837 {
    public static class Bean {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public BigDecimal examScore = new BigDecimal("0.47");
    }

    public static class BeanDouble {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public Double value = 0.47;
    }

    public static class BeanFloat {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public Float value = 0.47f;
    }

    public static class BeanInteger {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public Integer value = 47;
    }

    @Test
    public void testBigDecimal() {
        Bean bean = new Bean();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"examScore\":\"0.47\"}", json);
        Bean parsed = JSON.parseObject(json, Bean.class);
        assertEquals(0, new BigDecimal("0.47").compareTo(parsed.examScore));
    }

    @Test
    public void testDouble() {
        BeanDouble bean = new BeanDouble();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"value\":\"0.47\"}", json);
    }

    @Test
    public void testFloat() {
        BeanFloat bean = new BeanFloat();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"value\":\"0.47\"}", json);
    }

    @Test
    public void testInteger() {
        BeanInteger bean = new BeanInteger();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"value\":\"47\"}", json);
    }
}
