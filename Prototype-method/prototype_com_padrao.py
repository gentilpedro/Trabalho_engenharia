# com_prototype.py
import copy

class Computador:
    def __init__(self, cpu, memoria, disco):
        self.cpu = cpu
        self.memoria = memoria
        self.disco = disco

    def exibir(self):
        print(f"Computador: CPU={self.cpu}, RAM={self.memoria}, Disco={self.disco}")

    def clone(self):
        return copy.deepcopy(self)

# Criando um protótipo
computador_base = Computador("i7", "16GB", "1TB")

# Clonando o protótipo
c1 = computador_base.clone()
c2 = computador_base.clone()

c1.exibir()
c2.exibir()
