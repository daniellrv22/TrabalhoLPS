-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29-Mar-2021 às 16:20
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `academia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_aluno`
--

CREATE TABLE `tbl_aluno` (
  `id_aluno` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `idade` int(11) NOT NULL,
  `mensalidade` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_aluno`
--

INSERT INTO `tbl_aluno` (`id_aluno`, `nome`, `cpf`, `endereco`, `idade`, `mensalidade`) VALUES
(12, 'gdfhgfh', '212.121.111-11', 'fdsfds3', 33, 323),
(17, 'daniel', '099.938.626-30', 'praca bias fortes', 21, 45),
(22, 'marcos', '123.333.333-33', 'aaaa', 12, 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_atendente`
--

CREATE TABLE `tbl_atendente` (
  `id_atendente` int(4) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `idade` int(11) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_atendente`
--

INSERT INTO `tbl_atendente` (`id_atendente`, `nome`, `cpf`, `endereco`, `idade`, `salario`) VALUES
(1, 'daniel', '099.938.626-30', 'dadadadad', 12, 11),
(5, 'pedro', '099.938.626-30', 'fortaleza', 54, 123);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_avaliacao`
--

CREATE TABLE `tbl_avaliacao` (
  `id_avaliacao` int(11) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_chekin`
--

CREATE TABLE `tbl_chekin` (
  `id_chekin` int(11) NOT NULL,
  `dataChekin` date NOT NULL,
  `horaChekin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_dieta`
--

CREATE TABLE `tbl_dieta` (
  `id_dieta` int(11) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_equipamento`
--

CREATE TABLE `tbl_equipamento` (
  `id_equipamento` int(11) NOT NULL,
  `dataCompra` date NOT NULL,
  `dataManutencao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_ficha`
--

CREATE TABLE `tbl_ficha` (
  `id_ficha` int(11) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_gerente`
--

CREATE TABLE `tbl_gerente` (
  `id_gerente` int(11) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_instrutor`
--

CREATE TABLE `tbl_instrutor` (
  `id_instrutor` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `idade` int(11) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_instrutor`
--

INSERT INTO `tbl_instrutor` (`id_instrutor`, `nome`, `cpf`, `endereco`, `idade`, `salario`) VALUES
(4, 'gabriel', '111.111.111-11', '12', 48, 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_nutricionista`
--

CREATE TABLE `tbl_nutricionista` (
  `id_nutricionista` int(4) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `idade` int(11) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_nutricionista`
--

INSERT INTO `tbl_nutricionista` (`id_nutricionista`, `nome`, `cpf`, `endereco`, `idade`, `salario`) VALUES
(3, 'carlos', '574.561.232-10', 'juiz de fora', 45, 2000);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbl_aluno`
--
ALTER TABLE `tbl_aluno`
  ADD PRIMARY KEY (`id_aluno`);

--
-- Índices para tabela `tbl_atendente`
--
ALTER TABLE `tbl_atendente`
  ADD PRIMARY KEY (`id_atendente`);

--
-- Índices para tabela `tbl_avaliacao`
--
ALTER TABLE `tbl_avaliacao`
  ADD PRIMARY KEY (`id_avaliacao`);

--
-- Índices para tabela `tbl_chekin`
--
ALTER TABLE `tbl_chekin`
  ADD PRIMARY KEY (`id_chekin`);

--
-- Índices para tabela `tbl_dieta`
--
ALTER TABLE `tbl_dieta`
  ADD PRIMARY KEY (`id_dieta`);

--
-- Índices para tabela `tbl_equipamento`
--
ALTER TABLE `tbl_equipamento`
  ADD PRIMARY KEY (`id_equipamento`);

--
-- Índices para tabela `tbl_ficha`
--
ALTER TABLE `tbl_ficha`
  ADD PRIMARY KEY (`id_ficha`);

--
-- Índices para tabela `tbl_gerente`
--
ALTER TABLE `tbl_gerente`
  ADD PRIMARY KEY (`id_gerente`);

--
-- Índices para tabela `tbl_instrutor`
--
ALTER TABLE `tbl_instrutor`
  ADD PRIMARY KEY (`id_instrutor`);

--
-- Índices para tabela `tbl_nutricionista`
--
ALTER TABLE `tbl_nutricionista`
  ADD PRIMARY KEY (`id_nutricionista`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_aluno`
--
ALTER TABLE `tbl_aluno`
  MODIFY `id_aluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de tabela `tbl_atendente`
--
ALTER TABLE `tbl_atendente`
  MODIFY `id_atendente` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tbl_avaliacao`
--
ALTER TABLE `tbl_avaliacao`
  MODIFY `id_avaliacao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_chekin`
--
ALTER TABLE `tbl_chekin`
  MODIFY `id_chekin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_dieta`
--
ALTER TABLE `tbl_dieta`
  MODIFY `id_dieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_equipamento`
--
ALTER TABLE `tbl_equipamento`
  MODIFY `id_equipamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_ficha`
--
ALTER TABLE `tbl_ficha`
  MODIFY `id_ficha` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_gerente`
--
ALTER TABLE `tbl_gerente`
  MODIFY `id_gerente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_instrutor`
--
ALTER TABLE `tbl_instrutor`
  MODIFY `id_instrutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tbl_nutricionista`
--
ALTER TABLE `tbl_nutricionista`
  MODIFY `id_nutricionista` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
