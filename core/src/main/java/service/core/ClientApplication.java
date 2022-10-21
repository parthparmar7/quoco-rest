package service.core;

import java.util.List;

public class ClientApplication {

    public ClientApplication() {
        this.SEED_ID = SEED_ID;
        this.clientInfo = clientInfo;
        this.quotationList = quotationList;
    }

    public void setSEED_ID(int SEED_ID) {
        this.SEED_ID = SEED_ID;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setQuotationList(List<Quotation> quotationList) {
        this.quotationList = quotationList;
    }



    public int getSEED_ID() {
        return SEED_ID;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public List<Quotation> getQuotationList() {
        return quotationList;
    }

    private int SEED_ID = 0;
    private ClientInfo clientInfo;
    private List<Quotation> quotationList;



}
