package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.db.po.Term;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/13.
 */

public class TermsRsp extends FuResponse {
    private List<Term> terms;

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }
}
