import java.util.HashMap;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(); // Criação do HashMap para armazenar os números e seus índices

    // Percorre o array nums
    for (int i = 0; i < nums.length; i++) {
      int need = target - nums[i]; // Calcula o valor necessário para atingir o target

      // Verifica se o valor necessário já está no HashMap
      if (map.containsKey(need)) {
        return new int[] { map.get(need), i }; // Retorna os índices se encontrar a soma desejada
      }

      // Armazena o valor atual e seu índice no HashMap
      map.put(nums[i], i);
    }

    return new int[] {}; // Retorna array vazio se não encontrar nenhuma combinação
  }
}
