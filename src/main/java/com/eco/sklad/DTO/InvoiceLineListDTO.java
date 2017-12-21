package com.eco.sklad.DTO;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

public class InvoiceLineListDTO {
    private List<InvoiceLineDTO> invoiceLineDTOList = new ArrayList<>();

    public InvoiceLineListDTO() {

    }
    public List<InvoiceLineDTO> getInvoiceLineDTOList() {
        return invoiceLineDTOList;
    }

    public void setInvoiceLineDTOList(List<InvoiceLineDTO> invoiceLineDTOList) {
        this.invoiceLineDTOList = invoiceLineDTOList;
    }

//    public void addLine(InvoiceLineDTO invoiceLineDTO){
//        this.add()
//    }

    @Override
    public String toString() {
        return "InvoiceLineListDTO{" +
                "invoiceLineDTOList=" + invoiceLineDTOList +
                '}';
    }
}
