package com.framework.code.domain;

import java.util.ArrayList;
import java.util.List;

public class JcShebZhuangtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JcShebZhuangtExample() {
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

        public Criteria andShebidIsNull() {
            addCriterion("shebid is null");
            return (Criteria) this;
        }

        public Criteria andShebidIsNotNull() {
            addCriterion("shebid is not null");
            return (Criteria) this;
        }

        public Criteria andShebidEqualTo(Long value) {
            addCriterion("shebid =", value, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidNotEqualTo(Long value) {
            addCriterion("shebid <>", value, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidGreaterThan(Long value) {
            addCriterion("shebid >", value, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidGreaterThanOrEqualTo(Long value) {
            addCriterion("shebid >=", value, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidLessThan(Long value) {
            addCriterion("shebid <", value, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidLessThanOrEqualTo(Long value) {
            addCriterion("shebid <=", value, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidIn(List<Long> values) {
            addCriterion("shebid in", values, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidNotIn(List<Long> values) {
            addCriterion("shebid not in", values, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidBetween(Long value1, Long value2) {
            addCriterion("shebid between", value1, value2, "shebid");
            return (Criteria) this;
        }

        public Criteria andShebidNotBetween(Long value1, Long value2) {
            addCriterion("shebid not between", value1, value2, "shebid");
            return (Criteria) this;
        }

        public Criteria andCansbbidIsNull() {
            addCriterion("cansbbid is null");
            return (Criteria) this;
        }

        public Criteria andCansbbidIsNotNull() {
            addCriterion("cansbbid is not null");
            return (Criteria) this;
        }

        public Criteria andCansbbidEqualTo(Integer value) {
            addCriterion("cansbbid =", value, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidNotEqualTo(Integer value) {
            addCriterion("cansbbid <>", value, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidGreaterThan(Integer value) {
            addCriterion("cansbbid >", value, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cansbbid >=", value, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidLessThan(Integer value) {
            addCriterion("cansbbid <", value, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidLessThanOrEqualTo(Integer value) {
            addCriterion("cansbbid <=", value, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidIn(List<Integer> values) {
            addCriterion("cansbbid in", values, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidNotIn(List<Integer> values) {
            addCriterion("cansbbid not in", values, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidBetween(Integer value1, Integer value2) {
            addCriterion("cansbbid between", value1, value2, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andCansbbidNotBetween(Integer value1, Integer value2) {
            addCriterion("cansbbid not between", value1, value2, "cansbbid");
            return (Criteria) this;
        }

        public Criteria andWenkzt1IsNull() {
            addCriterion("wenkzt1 is null");
            return (Criteria) this;
        }

        public Criteria andWenkzt1IsNotNull() {
            addCriterion("wenkzt1 is not null");
            return (Criteria) this;
        }

        public Criteria andWenkzt1EqualTo(Integer value) {
            addCriterion("wenkzt1 =", value, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1NotEqualTo(Integer value) {
            addCriterion("wenkzt1 <>", value, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1GreaterThan(Integer value) {
            addCriterion("wenkzt1 >", value, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1GreaterThanOrEqualTo(Integer value) {
            addCriterion("wenkzt1 >=", value, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1LessThan(Integer value) {
            addCriterion("wenkzt1 <", value, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1LessThanOrEqualTo(Integer value) {
            addCriterion("wenkzt1 <=", value, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1In(List<Integer> values) {
            addCriterion("wenkzt1 in", values, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1NotIn(List<Integer> values) {
            addCriterion("wenkzt1 not in", values, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1Between(Integer value1, Integer value2) {
            addCriterion("wenkzt1 between", value1, value2, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt1NotBetween(Integer value1, Integer value2) {
            addCriterion("wenkzt1 not between", value1, value2, "wenkzt1");
            return (Criteria) this;
        }

        public Criteria andWenkzt2IsNull() {
            addCriterion("wenkzt2 is null");
            return (Criteria) this;
        }

        public Criteria andWenkzt2IsNotNull() {
            addCriterion("wenkzt2 is not null");
            return (Criteria) this;
        }

        public Criteria andWenkzt2EqualTo(Integer value) {
            addCriterion("wenkzt2 =", value, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2NotEqualTo(Integer value) {
            addCriterion("wenkzt2 <>", value, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2GreaterThan(Integer value) {
            addCriterion("wenkzt2 >", value, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2GreaterThanOrEqualTo(Integer value) {
            addCriterion("wenkzt2 >=", value, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2LessThan(Integer value) {
            addCriterion("wenkzt2 <", value, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2LessThanOrEqualTo(Integer value) {
            addCriterion("wenkzt2 <=", value, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2In(List<Integer> values) {
            addCriterion("wenkzt2 in", values, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2NotIn(List<Integer> values) {
            addCriterion("wenkzt2 not in", values, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2Between(Integer value1, Integer value2) {
            addCriterion("wenkzt2 between", value1, value2, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt2NotBetween(Integer value1, Integer value2) {
            addCriterion("wenkzt2 not between", value1, value2, "wenkzt2");
            return (Criteria) this;
        }

        public Criteria andWenkzt3IsNull() {
            addCriterion("wenkzt3 is null");
            return (Criteria) this;
        }

        public Criteria andWenkzt3IsNotNull() {
            addCriterion("wenkzt3 is not null");
            return (Criteria) this;
        }

        public Criteria andWenkzt3EqualTo(Integer value) {
            addCriterion("wenkzt3 =", value, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3NotEqualTo(Integer value) {
            addCriterion("wenkzt3 <>", value, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3GreaterThan(Integer value) {
            addCriterion("wenkzt3 >", value, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3GreaterThanOrEqualTo(Integer value) {
            addCriterion("wenkzt3 >=", value, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3LessThan(Integer value) {
            addCriterion("wenkzt3 <", value, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3LessThanOrEqualTo(Integer value) {
            addCriterion("wenkzt3 <=", value, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3In(List<Integer> values) {
            addCriterion("wenkzt3 in", values, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3NotIn(List<Integer> values) {
            addCriterion("wenkzt3 not in", values, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3Between(Integer value1, Integer value2) {
            addCriterion("wenkzt3 between", value1, value2, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andWenkzt3NotBetween(Integer value1, Integer value2) {
            addCriterion("wenkzt3 not between", value1, value2, "wenkzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt1IsNull() {
            addCriterion("jiarzt1 is null");
            return (Criteria) this;
        }

        public Criteria andJiarzt1IsNotNull() {
            addCriterion("jiarzt1 is not null");
            return (Criteria) this;
        }

        public Criteria andJiarzt1EqualTo(Integer value) {
            addCriterion("jiarzt1 =", value, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1NotEqualTo(Integer value) {
            addCriterion("jiarzt1 <>", value, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1GreaterThan(Integer value) {
            addCriterion("jiarzt1 >", value, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1GreaterThanOrEqualTo(Integer value) {
            addCriterion("jiarzt1 >=", value, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1LessThan(Integer value) {
            addCriterion("jiarzt1 <", value, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1LessThanOrEqualTo(Integer value) {
            addCriterion("jiarzt1 <=", value, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1In(List<Integer> values) {
            addCriterion("jiarzt1 in", values, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1NotIn(List<Integer> values) {
            addCriterion("jiarzt1 not in", values, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1Between(Integer value1, Integer value2) {
            addCriterion("jiarzt1 between", value1, value2, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt1NotBetween(Integer value1, Integer value2) {
            addCriterion("jiarzt1 not between", value1, value2, "jiarzt1");
            return (Criteria) this;
        }

        public Criteria andJiarzt2IsNull() {
            addCriterion("jiarzt2 is null");
            return (Criteria) this;
        }

        public Criteria andJiarzt2IsNotNull() {
            addCriterion("jiarzt2 is not null");
            return (Criteria) this;
        }

        public Criteria andJiarzt2EqualTo(Integer value) {
            addCriterion("jiarzt2 =", value, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2NotEqualTo(Integer value) {
            addCriterion("jiarzt2 <>", value, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2GreaterThan(Integer value) {
            addCriterion("jiarzt2 >", value, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2GreaterThanOrEqualTo(Integer value) {
            addCriterion("jiarzt2 >=", value, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2LessThan(Integer value) {
            addCriterion("jiarzt2 <", value, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2LessThanOrEqualTo(Integer value) {
            addCriterion("jiarzt2 <=", value, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2In(List<Integer> values) {
            addCriterion("jiarzt2 in", values, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2NotIn(List<Integer> values) {
            addCriterion("jiarzt2 not in", values, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2Between(Integer value1, Integer value2) {
            addCriterion("jiarzt2 between", value1, value2, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt2NotBetween(Integer value1, Integer value2) {
            addCriterion("jiarzt2 not between", value1, value2, "jiarzt2");
            return (Criteria) this;
        }

        public Criteria andJiarzt3IsNull() {
            addCriterion("jiarzt3 is null");
            return (Criteria) this;
        }

        public Criteria andJiarzt3IsNotNull() {
            addCriterion("jiarzt3 is not null");
            return (Criteria) this;
        }

        public Criteria andJiarzt3EqualTo(Integer value) {
            addCriterion("jiarzt3 =", value, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3NotEqualTo(Integer value) {
            addCriterion("jiarzt3 <>", value, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3GreaterThan(Integer value) {
            addCriterion("jiarzt3 >", value, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3GreaterThanOrEqualTo(Integer value) {
            addCriterion("jiarzt3 >=", value, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3LessThan(Integer value) {
            addCriterion("jiarzt3 <", value, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3LessThanOrEqualTo(Integer value) {
            addCriterion("jiarzt3 <=", value, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3In(List<Integer> values) {
            addCriterion("jiarzt3 in", values, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3NotIn(List<Integer> values) {
            addCriterion("jiarzt3 not in", values, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3Between(Integer value1, Integer value2) {
            addCriterion("jiarzt3 between", value1, value2, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andJiarzt3NotBetween(Integer value1, Integer value2) {
            addCriterion("jiarzt3 not between", value1, value2, "jiarzt3");
            return (Criteria) this;
        }

        public Criteria andWend1IsNull() {
            addCriterion("wend1 is null");
            return (Criteria) this;
        }

        public Criteria andWend1IsNotNull() {
            addCriterion("wend1 is not null");
            return (Criteria) this;
        }

        public Criteria andWend1EqualTo(Integer value) {
            addCriterion("wend1 =", value, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1NotEqualTo(Integer value) {
            addCriterion("wend1 <>", value, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1GreaterThan(Integer value) {
            addCriterion("wend1 >", value, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1GreaterThanOrEqualTo(Integer value) {
            addCriterion("wend1 >=", value, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1LessThan(Integer value) {
            addCriterion("wend1 <", value, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1LessThanOrEqualTo(Integer value) {
            addCriterion("wend1 <=", value, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1In(List<Integer> values) {
            addCriterion("wend1 in", values, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1NotIn(List<Integer> values) {
            addCriterion("wend1 not in", values, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1Between(Integer value1, Integer value2) {
            addCriterion("wend1 between", value1, value2, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend1NotBetween(Integer value1, Integer value2) {
            addCriterion("wend1 not between", value1, value2, "wend1");
            return (Criteria) this;
        }

        public Criteria andWend2IsNull() {
            addCriterion("wend2 is null");
            return (Criteria) this;
        }

        public Criteria andWend2IsNotNull() {
            addCriterion("wend2 is not null");
            return (Criteria) this;
        }

        public Criteria andWend2EqualTo(Integer value) {
            addCriterion("wend2 =", value, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2NotEqualTo(Integer value) {
            addCriterion("wend2 <>", value, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2GreaterThan(Integer value) {
            addCriterion("wend2 >", value, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2GreaterThanOrEqualTo(Integer value) {
            addCriterion("wend2 >=", value, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2LessThan(Integer value) {
            addCriterion("wend2 <", value, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2LessThanOrEqualTo(Integer value) {
            addCriterion("wend2 <=", value, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2In(List<Integer> values) {
            addCriterion("wend2 in", values, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2NotIn(List<Integer> values) {
            addCriterion("wend2 not in", values, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2Between(Integer value1, Integer value2) {
            addCriterion("wend2 between", value1, value2, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend2NotBetween(Integer value1, Integer value2) {
            addCriterion("wend2 not between", value1, value2, "wend2");
            return (Criteria) this;
        }

        public Criteria andWend3IsNull() {
            addCriterion("wend3 is null");
            return (Criteria) this;
        }

        public Criteria andWend3IsNotNull() {
            addCriterion("wend3 is not null");
            return (Criteria) this;
        }

        public Criteria andWend3EqualTo(Integer value) {
            addCriterion("wend3 =", value, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3NotEqualTo(Integer value) {
            addCriterion("wend3 <>", value, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3GreaterThan(Integer value) {
            addCriterion("wend3 >", value, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3GreaterThanOrEqualTo(Integer value) {
            addCriterion("wend3 >=", value, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3LessThan(Integer value) {
            addCriterion("wend3 <", value, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3LessThanOrEqualTo(Integer value) {
            addCriterion("wend3 <=", value, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3In(List<Integer> values) {
            addCriterion("wend3 in", values, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3NotIn(List<Integer> values) {
            addCriterion("wend3 not in", values, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3Between(Integer value1, Integer value2) {
            addCriterion("wend3 between", value1, value2, "wend3");
            return (Criteria) this;
        }

        public Criteria andWend3NotBetween(Integer value1, Integer value2) {
            addCriterion("wend3 not between", value1, value2, "wend3");
            return (Criteria) this;
        }

        public Criteria andShidIsNull() {
            addCriterion("shid is null");
            return (Criteria) this;
        }

        public Criteria andShidIsNotNull() {
            addCriterion("shid is not null");
            return (Criteria) this;
        }

        public Criteria andShidEqualTo(Integer value) {
            addCriterion("shid =", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotEqualTo(Integer value) {
            addCriterion("shid <>", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThan(Integer value) {
            addCriterion("shid >", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shid >=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThan(Integer value) {
            addCriterion("shid <", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThanOrEqualTo(Integer value) {
            addCriterion("shid <=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidIn(List<Integer> values) {
            addCriterion("shid in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotIn(List<Integer> values) {
            addCriterion("shid not in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidBetween(Integer value1, Integer value2) {
            addCriterion("shid between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotBetween(Integer value1, Integer value2) {
            addCriterion("shid not between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andGongzmsIsNull() {
            addCriterion("gongzms is null");
            return (Criteria) this;
        }

        public Criteria andGongzmsIsNotNull() {
            addCriterion("gongzms is not null");
            return (Criteria) this;
        }

        public Criteria andGongzmsEqualTo(Integer value) {
            addCriterion("gongzms =", value, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsNotEqualTo(Integer value) {
            addCriterion("gongzms <>", value, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsGreaterThan(Integer value) {
            addCriterion("gongzms >", value, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("gongzms >=", value, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsLessThan(Integer value) {
            addCriterion("gongzms <", value, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsLessThanOrEqualTo(Integer value) {
            addCriterion("gongzms <=", value, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsIn(List<Integer> values) {
            addCriterion("gongzms in", values, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsNotIn(List<Integer> values) {
            addCriterion("gongzms not in", values, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsBetween(Integer value1, Integer value2) {
            addCriterion("gongzms between", value1, value2, "gongzms");
            return (Criteria) this;
        }

        public Criteria andGongzmsNotBetween(Integer value1, Integer value2) {
            addCriterion("gongzms not between", value1, value2, "gongzms");
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