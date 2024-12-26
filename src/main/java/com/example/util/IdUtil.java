package com.example.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdUtil {

    public static Set<Integer> gerarIdAleatorios(int quantidade, int maxId) {
        Set<Integer> ids = new HashSet<>();
        Random random = new Random();

        // Gerar IDs únicos aleatórios no intervalo de 1 a maxId
        while (ids.size() < quantidade) {
            int idAleatorio = random.nextInt(maxId) + 1; // Gera números entre 1 e maxId inclusivos
            ids.add(idAleatorio);
        }

        return ids;
    }
}
