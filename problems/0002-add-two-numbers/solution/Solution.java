public class Solution {

  // Método principal que soma dois números representados como listas encadeadas
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    // Nó auxiliar para facilitar a construção da lista de resultado
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;

    // Variável para armazenar o transporte (carry) quando a soma é maior que 9
    int carry = 0; 

    // Percorre as listas enquanto houver elementos ou transporte pendente
    while (l1 != null || l2 != null || carry != 0) {

      // Pega o valor do nó atual de l1 ou 0 se já chegou ao final
      int x = (l1 != null) ? l1.val : 0;

      // Pega o valor do nó atual de l2 ou 0 se já chegou ao final
      int y = (l2 != null) ? l2.val : 0;

      // Soma os valores dos nós e o carry
      int sum = x + y + carry;

      // Atualiza o carry para a próxima iteração
      carry = sum / 10;

      // Cria um novo nó com o valor da soma módulo 10
      curr.next = new ListNode(sum % 10);

      // Move o ponteiro para o próximo nó
      curr = curr.next;

      // Avança l1, se ainda não chegou ao final
      if (l1 != null) {
        l1 = l1.next;
      }
      // Avança l2, se ainda não chegou ao final
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    // Retorna a lista resultante (ignorando o nó auxiliar)
    return dummyHead.next;
  }

  // Método auxiliar para imprimir a lista encadeada
  public void printSolution(ListNode node) {
    while (node != null) {
      System.out.print(node.val);
      if (node.next != null) {
        System.out.print(" -> ");
      }
      node = node.next;
    }
    System.out.println();
  }
}
