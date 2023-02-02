namespace BubbleSort.App
{
    class Program
    {
        static void Main(string[] args)
        {
            var bubbleSort = new BubbleSort();

            var numerosOrdenados = bubbleSort.OrdenaNumeros();

            //TODO:remover apos testes
            bubbleSort.ShowResults(numerosOrdenados);
        }
    }
}
