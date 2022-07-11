package tsi.lojaquadrinhos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class LojaQuadrinhos {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Item[] itens = {
            new Adesivo(),
            new Busto(),
            new Camiseta(),
            new Caneta(),
            new Chaveiro(),
            new Miniatura(),
            new Poster(),
            new Quadrinho()
        };
        
        HashMap<Item, Integer> itensSorteados = new HashMap<>();
        Integer nivel;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Digite o nível do cliente para sortear:");
            System.out.println("1 - Bronze");
            System.out.println("2 - Prata");
            System.out.println("3 - Outro");
            System.out.println("4 - Platina");

            nivel = scanner.nextInt();
            Integer quantidade = 0;
            boolean nivelInvalido = false;
            switch (nivel) {
                case 1:
                    quantidade = 3;
                    break;
                case 2:
                    quantidade = 5;
                    break;
                case 3:
                    quantidade = 7;
                    break;
                case 4:
                    quantidade = 10;
                    break;
                default:
                    nivelInvalido = true;
                    System.out.println("Nivel invalido!");
                    break;
            }
            
            if (nivelInvalido) continue;

            for (int i = 0; i < quantidade; i++) {
                Random rand = new Random();
                Item itemAleatorio = itens[rand.nextInt(itens.length)];
                
                if (itensSorteados.containsKey(itemAleatorio)) {
                    itensSorteados.replace(itemAleatorio, itensSorteados.get(itemAleatorio) + 1);
                } else {
                    itensSorteados.put(itemAleatorio, 1);
                }
            }
            
            System.out.println("Items sorteados:");
            Float valorTotal = 0f;
            for (Map.Entry<Item, Integer> entry : itensSorteados.entrySet()) {
                Item item = entry.getKey();
                Integer qtdItem = entry.getValue();
                
                System.out.println(item.getNome() + "(" + qtdItem + "): " + item.getValor() * qtdItem);
                valorTotal += item.getValor() * qtdItem;
            }
            System.out.println("Valor total: " + valorTotal);
            itensSorteados.clear();
        } while(nivel != 0);
        scanner.close();
        
    }
}
