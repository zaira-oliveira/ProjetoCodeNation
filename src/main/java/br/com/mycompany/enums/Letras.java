package br.com.mycompany.enums;

public enum Letras {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8),
    I(9),
    J(10),
    K(11),
    L(12),
    M(13),
    N(14),
    O(15),
    P(16),
    Q(17),
    R(18),
    S(19),
    T(20),
    U(21),
    V(22),
    W(23),
    X(24),
    Y(25),
    Z(26);

    Letras(int valor) {
        this.valor = valor;
    }
    private int valor;

    public int getValor() {
        return this.valor;
    }

    public static Letras getLetraByValor(int valor) {
        if (valor <= 0) {
            valor += (Letras.values().length);
        } else if (valor > Letras.values().length) {
            valor -= (Letras.values().length);
        }
        for (Letras letra : Letras.values()) {

            if (letra.getValor() == valor) {
                return letra;
            }
        }
        return null;
    }

}
