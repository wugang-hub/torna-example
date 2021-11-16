package cn.torna.tornaexample.common;

import java.io.Serializable;

public class ParamVo<P, C> implements Serializable {
    private static final long serialVersionUID = 1L;
    private P pagger;
    private C condition;

    public ParamVo() {
    }

    public P getPagger() {
        return this.pagger;
    }

    public void setPagger(P pagger) {
        this.pagger = pagger;
    }

    public C getCondition() {
        return this.condition;
    }

    public void setCondition(C condition) {
        this.condition = condition;
    }
}