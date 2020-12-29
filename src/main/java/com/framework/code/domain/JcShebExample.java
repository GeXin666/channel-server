package com.framework.code.domain;

import java.util.ArrayList;
import java.util.List;

public class JcShebExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JcShebExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMingcIsNull() {
            addCriterion("mingc is null");
            return (Criteria) this;
        }

        public Criteria andMingcIsNotNull() {
            addCriterion("mingc is not null");
            return (Criteria) this;
        }

        public Criteria andMingcEqualTo(String value) {
            addCriterion("mingc =", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcNotEqualTo(String value) {
            addCriterion("mingc <>", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcGreaterThan(String value) {
            addCriterion("mingc >", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcGreaterThanOrEqualTo(String value) {
            addCriterion("mingc >=", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcLessThan(String value) {
            addCriterion("mingc <", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcLessThanOrEqualTo(String value) {
            addCriterion("mingc <=", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcLike(String value) {
            addCriterion("mingc like", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcNotLike(String value) {
            addCriterion("mingc not like", value, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcIn(List<String> values) {
            addCriterion("mingc in", values, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcNotIn(List<String> values) {
            addCriterion("mingc not in", values, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcBetween(String value1, String value2) {
            addCriterion("mingc between", value1, value2, "mingc");
            return (Criteria) this;
        }

        public Criteria andMingcNotBetween(String value1, String value2) {
            addCriterion("mingc not between", value1, value2, "mingc");
            return (Criteria) this;
        }

        public Criteria andJianpIsNull() {
            addCriterion("jianp is null");
            return (Criteria) this;
        }

        public Criteria andJianpIsNotNull() {
            addCriterion("jianp is not null");
            return (Criteria) this;
        }

        public Criteria andJianpEqualTo(String value) {
            addCriterion("jianp =", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpNotEqualTo(String value) {
            addCriterion("jianp <>", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpGreaterThan(String value) {
            addCriterion("jianp >", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpGreaterThanOrEqualTo(String value) {
            addCriterion("jianp >=", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpLessThan(String value) {
            addCriterion("jianp <", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpLessThanOrEqualTo(String value) {
            addCriterion("jianp <=", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpLike(String value) {
            addCriterion("jianp like", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpNotLike(String value) {
            addCriterion("jianp not like", value, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpIn(List<String> values) {
            addCriterion("jianp in", values, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpNotIn(List<String> values) {
            addCriterion("jianp not in", values, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpBetween(String value1, String value2) {
            addCriterion("jianp between", value1, value2, "jianp");
            return (Criteria) this;
        }

        public Criteria andJianpNotBetween(String value1, String value2) {
            addCriterion("jianp not between", value1, value2, "jianp");
            return (Criteria) this;
        }

        public Criteria andShebdzIsNull() {
            addCriterion("shebdz is null");
            return (Criteria) this;
        }

        public Criteria andShebdzIsNotNull() {
            addCriterion("shebdz is not null");
            return (Criteria) this;
        }

        public Criteria andShebdzEqualTo(Integer value) {
            addCriterion("shebdz =", value, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzNotEqualTo(Integer value) {
            addCriterion("shebdz <>", value, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzGreaterThan(Integer value) {
            addCriterion("shebdz >", value, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzGreaterThanOrEqualTo(Integer value) {
            addCriterion("shebdz >=", value, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzLessThan(Integer value) {
            addCriterion("shebdz <", value, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzLessThanOrEqualTo(Integer value) {
            addCriterion("shebdz <=", value, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzIn(List<Integer> values) {
            addCriterion("shebdz in", values, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzNotIn(List<Integer> values) {
            addCriterion("shebdz not in", values, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzBetween(Integer value1, Integer value2) {
            addCriterion("shebdz between", value1, value2, "shebdz");
            return (Criteria) this;
        }

        public Criteria andShebdzNotBetween(Integer value1, Integer value2) {
            addCriterion("shebdz not between", value1, value2, "shebdz");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidIsNull() {
            addCriterion("chuankfwqdkid is null");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidIsNotNull() {
            addCriterion("chuankfwqdkid is not null");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidEqualTo(Long value) {
            addCriterion("chuankfwqdkid =", value, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidNotEqualTo(Long value) {
            addCriterion("chuankfwqdkid <>", value, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidGreaterThan(Long value) {
            addCriterion("chuankfwqdkid >", value, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidGreaterThanOrEqualTo(Long value) {
            addCriterion("chuankfwqdkid >=", value, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidLessThan(Long value) {
            addCriterion("chuankfwqdkid <", value, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidLessThanOrEqualTo(Long value) {
            addCriterion("chuankfwqdkid <=", value, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidIn(List<Long> values) {
            addCriterion("chuankfwqdkid in", values, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidNotIn(List<Long> values) {
            addCriterion("chuankfwqdkid not in", values, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidBetween(Long value1, Long value2) {
            addCriterion("chuankfwqdkid between", value1, value2, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andChuankfwqdkidNotBetween(Long value1, Long value2) {
            addCriterion("chuankfwqdkid not between", value1, value2, "chuankfwqdkid");
            return (Criteria) this;
        }

        public Criteria andPaixhIsNull() {
            addCriterion("paixh is null");
            return (Criteria) this;
        }

        public Criteria andPaixhIsNotNull() {
            addCriterion("paixh is not null");
            return (Criteria) this;
        }

        public Criteria andPaixhEqualTo(Integer value) {
            addCriterion("paixh =", value, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhNotEqualTo(Integer value) {
            addCriterion("paixh <>", value, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhGreaterThan(Integer value) {
            addCriterion("paixh >", value, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhGreaterThanOrEqualTo(Integer value) {
            addCriterion("paixh >=", value, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhLessThan(Integer value) {
            addCriterion("paixh <", value, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhLessThanOrEqualTo(Integer value) {
            addCriterion("paixh <=", value, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhIn(List<Integer> values) {
            addCriterion("paixh in", values, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhNotIn(List<Integer> values) {
            addCriterion("paixh not in", values, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhBetween(Integer value1, Integer value2) {
            addCriterion("paixh between", value1, value2, "paixh");
            return (Criteria) this;
        }

        public Criteria andPaixhNotBetween(Integer value1, Integer value2) {
            addCriterion("paixh not between", value1, value2, "paixh");
            return (Criteria) this;
        }

        public Criteria andZhuangtIsNull() {
            addCriterion("zhuangt is null");
            return (Criteria) this;
        }

        public Criteria andZhuangtIsNotNull() {
            addCriterion("zhuangt is not null");
            return (Criteria) this;
        }

        public Criteria andZhuangtEqualTo(Integer value) {
            addCriterion("zhuangt =", value, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtNotEqualTo(Integer value) {
            addCriterion("zhuangt <>", value, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtGreaterThan(Integer value) {
            addCriterion("zhuangt >", value, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhuangt >=", value, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtLessThan(Integer value) {
            addCriterion("zhuangt <", value, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtLessThanOrEqualTo(Integer value) {
            addCriterion("zhuangt <=", value, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtIn(List<Integer> values) {
            addCriterion("zhuangt in", values, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtNotIn(List<Integer> values) {
            addCriterion("zhuangt not in", values, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtBetween(Integer value1, Integer value2) {
            addCriterion("zhuangt between", value1, value2, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andZhuangtNotBetween(Integer value1, Integer value2) {
            addCriterion("zhuangt not between", value1, value2, "zhuangt");
            return (Criteria) this;
        }

        public Criteria andBeizIsNull() {
            addCriterion("beiz is null");
            return (Criteria) this;
        }

        public Criteria andBeizIsNotNull() {
            addCriterion("beiz is not null");
            return (Criteria) this;
        }

        public Criteria andBeizEqualTo(String value) {
            addCriterion("beiz =", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotEqualTo(String value) {
            addCriterion("beiz <>", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizGreaterThan(String value) {
            addCriterion("beiz >", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizGreaterThanOrEqualTo(String value) {
            addCriterion("beiz >=", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizLessThan(String value) {
            addCriterion("beiz <", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizLessThanOrEqualTo(String value) {
            addCriterion("beiz <=", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizLike(String value) {
            addCriterion("beiz like", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotLike(String value) {
            addCriterion("beiz not like", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizIn(List<String> values) {
            addCriterion("beiz in", values, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotIn(List<String> values) {
            addCriterion("beiz not in", values, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizBetween(String value1, String value2) {
            addCriterion("beiz between", value1, value2, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotBetween(String value1, String value2) {
            addCriterion("beiz not between", value1, value2, "beiz");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}