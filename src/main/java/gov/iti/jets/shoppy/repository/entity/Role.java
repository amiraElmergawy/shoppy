package gov.iti.jets.shoppy.repository.entity;

public enum Role {
    ADMIN(1),
    CUSTOMER(2);
    private final int value;
    private Role(int value) {
        this.value = value;
    }
}
