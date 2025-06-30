
class Veiculo {
  dirigir() {
    throw new Error("Método abstrato!");
  }
}

class Carro extends Veiculo {
  dirigir() {
    console.log("Dirigindo um carro.");
  }
}

class Moto extends Veiculo {
  dirigir() {
    console.log("Pilotando uma moto.");
  }
}

class FabricaDeVeiculo {
  criarVeiculo() {
    throw new Error("Método abstrato!");
  }
}

class FabricaDeCarro extends FabricaDeVeiculo {
  criarVeiculo() {
    return new Carro();
  }
}

class FabricaDeMoto extends FabricaDeVeiculo {
  criarVeiculo() {
    return new Moto();
  }
}

function usarVeiculo(fabrica) {
  const veiculo = fabrica.criarVeiculo();
  veiculo.dirigir();
}

const fabrica = new FabricaDeCarro(); 
usarVeiculo(fabrica);
