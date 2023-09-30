package com.prospect.manager.infrastructure.enums;

public enum ProspectAnalysisStatus {

    AWAITING_ANALYSIS("Aguardando Análise"),
    APPROVED("Aprovado"),
    REPPROVED("Reprovado");

    private final String description;

    ProspectAnalysisStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
