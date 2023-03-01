/**
 * Exercice 1 : Trouver K Éléments Les Plus Présents Dans Le Tableau Donné
 * Instruction
 * Étant donné un tableau de N nombres et un entier positif K. Le problème est de trouver K nombres avec le plus d'occurrences,
 * c'est-à-dire les K nombres supérieurs ayant la fréquence maximale. Si deux nombres ont la même fréquence, le nombre avec une valeur
 * plus grande doit être privilégié. Les nombres doivent être affichés dans l'ordre décroissant de leurs fréquences. On suppose que le tableau
 * est composé d'au moins K nombres.
 *
 * Exemples:
 *
 * Input: arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, K = 2
 * Output: 4 1
 * Explanation:
 * Frequency of 4 = 2, Frequency of 1 = 2
 * These two have the maximum frequency and 4 is larger than 1.
 *
 * Input: arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, K = 4
 * Output: 5 11 7 10
 * Explanation:
 * Frequency of 5 = 3, Frequency of 11 = 2, Frequency of 7 = 2, Frequency of 10 = 1
 * These four have the maximum frequency and 5 is largest among rest.
 *
 *
 * Pour résoudre le problème en utilisant cette approche, suivez l'idée ci-dessous :
 *
 * créer une carte pour stocker la paire élément-fréquence. La carte est utilisée pour effectuer l'insertion et la mise
 * à jour en temps constant. Triez ensuite le couple élément-fréquence par ordre décroissant de fréquence.
 * Cela donne les informations sur chaque élément et le nombre de fois où ils sont présents dans le tableau.
 * Pour obtenir K éléments du tableau, imprimez les K premiers éléments du tableau trié.
 *
 * Suivez les étapes indiquées pour résoudre le problème :
 *
 * Créez une carte mp, pour stocker la paire clé-valeur, c'est-à-dire la paire élément-fréquence.
 * Parcourez le tableau du début à la fin.
 * Pour chaque élément de la mise à jour du tableaump[array[i]]++
 * Stockez la paire élément-fréquence dans un vecteur et triez le vecteur par ordre décroissant de fréquence.
 * Affiche les k premiers éléments du tableau trié.
 */

package exercice1;

import java.util.*;

public class KMostFrequentElements {
    
    public static void main(String[] args) {
        
        int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        
        // Step 1: Create a map to store element-frequency pair
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 2: Traverse the array and update frequency in map
        for(int i=0; i<arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        
        // Step 3: Convert map into a list of element-frequency pairs
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());
        
        // Step 4: Sort the list in decreasing order of frequency
        Collections.sort(freqList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o2.getKey() - o1.getKey();
                }
            }
        });
        
        // Step 5: Print the top k elements from the sorted list
        for(int i=0; i<k; i++) {
            System.out.print(freqList.get(i).getKey() + " ");
        }
    }
}
