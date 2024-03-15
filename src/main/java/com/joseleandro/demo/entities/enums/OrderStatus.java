package com.joseleandro.demo.entities.enums;

// Declaração do enum OrderStatus, que representa os possíveis estados de um pedido
public enum OrderStatus {
    
    // Definição das constantes do enum com seus valores associados
    WAITING_PAYMENT(1), 
    PAID(2), 
    SHIPPED(3), 
    DELIVERED(4), 
    CANCELED(5);
    
    // Variável de instância para armazenar o código associado a cada estado
    private int code;
    
    // Construtor do enum OrderStatus, que recebe o código associado a cada estado como argumento
    private OrderStatus(int code) {
        this.code = code;
    }
    
    // Método que retorna o código associado a cada estado do pedido
    public int getCode() {
        return code;
    }
    
    // Método ESTÁTICO para obter o valor do enum correspondente a um código fornecido
    public static OrderStatus valueOf(int code) {
        // Itera sobre todas as constantes do enum
        for (OrderStatus value: OrderStatus.values()) {
            // Compara o código fornecido com o código de cada constante
            if (value.getCode() == code) {
                // Se encontrar uma correspondência, retorna a constante correspondente
                return value;
            }
        }
        // Se nenhum código correspondente for encontrado, lança uma exceção
        throw new IllegalArgumentException("Invalid code");
    }
}

