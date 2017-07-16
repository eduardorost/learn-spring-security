package br.com.learnspringsecurity.enums;

public enum ModuleType {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");
    private String module;

    ModuleType(String module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return this.module;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
