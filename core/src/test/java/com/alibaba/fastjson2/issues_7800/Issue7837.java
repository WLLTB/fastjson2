package com.alibaba.fastjson2.issues_7800;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

    public static class BeanObject {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public Object examScore = new BigDecimal("0.47");
    }

    public static class BeanObjectMillis {
        @JSONField(format = "millis")
        public Object examScore = new BigDecimal("0.47");
    }

    public static class BeanMillisDouble {
        @JSONField(format = "millis")
        public Double value = 0.47;
    }

    public static class BeanMillisBigDecimal {
        @JSONField(format = "millis")
        public BigDecimal value = new BigDecimal("0.47");
    }

    public static class BeanMillisBigDecimalArray {
        @JSONField(format = "millis")
        public BigDecimal[] scores = {new BigDecimal("0.47")};
    }

    public static class BeanObjectBigDecimalArray {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public Object scores = new BigDecimal[]{new BigDecimal("0.47")};
    }

    public static class BeanObjectMillisBigDecimalArray {
        @JSONField(format = "millis")
        public Object scores = new BigDecimal[]{new BigDecimal("0.47")};
    }

    public static class BeanStringDoubleList {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public List<Double> values = Arrays.asList(0.47, 2.0);
    }

    public static class BeanStringBigDecimalList {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public List<BigDecimal> values = Arrays.asList(new BigDecimal("0.47"));
    }

    public static class BeanStringFloatList {
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public List<Float> values = Arrays.asList(0.47f);
    }

    public static class BeanMillisDoubleList {
        @JSONField(format = "millis")
        public List<Double> values = Arrays.asList(0.47);
    }

    public static class BeanMillisBigDecimalList {
        @JSONField(format = "millis")
        public List<BigDecimal> values = Arrays.asList(new BigDecimal("0.47"));
    }

    public static class BeanMillisFloatList {
        @JSONField(format = "millis")
        public List<Float> values = Arrays.asList(0.47f);
    }

    public static class BeanTrimDouble {
        @JSONField(format = "trim")
        public Double value = 0.47;
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

    @Test
    public void testObjectBigDecimal() {
        BeanObject bean = new BeanObject();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"examScore\":\"0.47\"}", json);
    }

    @Test
    public void testObjectBigDecimalMillis() {
        BeanObjectMillis bean = new BeanObjectMillis();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"examScore\":0.47}", json);
    }

    @Test
    public void testMillisDouble() {
        BeanMillisDouble bean = new BeanMillisDouble();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"value\":0.47}", json);
    }

    @Test
    public void testMillisBigDecimal() {
        BeanMillisBigDecimal bean = new BeanMillisBigDecimal();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"value\":0.47}", json);
    }

    @Test
    public void testMillisBigDecimalArray() {
        BeanMillisBigDecimalArray bean = new BeanMillisBigDecimalArray();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"scores\":[0.47]}", json);
    }

    @Test
    public void testObjectBigDecimalArray() {
        BeanObjectBigDecimalArray bean = new BeanObjectBigDecimalArray();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"scores\":[\"0.47\"]}", json);
    }

    @Test
    public void testObjectMillisBigDecimalArray() {
        BeanObjectMillisBigDecimalArray bean = new BeanObjectMillisBigDecimalArray();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"scores\":[0.47]}", json);
    }

    @Test
    public void testStringDoubleList() {
        BeanStringDoubleList bean = new BeanStringDoubleList();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"values\":[\"0.47\",\"2.0\"]}", json);
    }

    @Test
    public void testStringBigDecimalList() {
        BeanStringBigDecimalList bean = new BeanStringBigDecimalList();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"values\":[\"0.47\"]}", json);
    }

    @Test
    public void testStringFloatList() {
        BeanStringFloatList bean = new BeanStringFloatList();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"values\":[\"0.47\"]}", json);
    }

    @Test
    public void testMillisDoubleList() {
        BeanMillisDoubleList bean = new BeanMillisDoubleList();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"values\":[0.47]}", json);
    }

    @Test
    public void testMillisBigDecimalList() {
        BeanMillisBigDecimalList bean = new BeanMillisBigDecimalList();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"values\":[0.47]}", json);
    }

    @Test
    public void testMillisFloatList() {
        BeanMillisFloatList bean = new BeanMillisFloatList();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"values\":[0.47]}", json);
    }

    @Test
    public void testTrimDouble() {
        BeanTrimDouble bean = new BeanTrimDouble();
        String json = JSON.toJSONString(bean);
        assertEquals("{\"value\":0.47}", json);
    }
}
