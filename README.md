# satc-backend-projeto-final

# Tema:  
    Saúde e Bem-estar: Gerenciamento de Medicamentos, Mapeamento de Atendimentos Médicos, Recomendações Médicas

# 1 Funcionalidades Gerais:
O que o sistema irá ter em uma visão geral de funcionalidades

## 1.1 Gerenciamento de Medicamentos:
* Lembretes para tomar medicamentos
* Rastreamento de adesão ao tratamento
* Alerta para interações com tipos de medicamentos

## 1.2 Mapeamento de Atendimentos Médicos:
* Registro de visitas médicas
* Análise de padrões de atendimento
* Sugestões de otimização de recursos médicos
* Sugestões de médicos e retornos
* Direcionamento para médicos especializados 
    
## 1.3 Recomendações Médicas:
* Sugestões personalizadas com base no histórico médico do paciente
* Análise preditiva para antecipar necessidades futuras
* monitoramento contínuo.

# 2 Funcionalidades Descritivas:
Funcionalidades e ações que cada papel pode fazer ou receber
## 2.1 Ações do paciente
### 2.1.1 Ações
* Cadastrar medicamentos
* Marcar consulta com médico
* Marcar exame

## 2.2 Ações do médico
### 2.1.1 Ações
* Cadastrar medicamentos para paciente
* Criar um resultado da consulta 
* Marcar um exame para paciente
* Criar resultado para exame (arquivos, laudos, etc..)

## 2.3 Ações da administração/hospital
### 2.1.1 Ações
* cadastrar médico
* cadastrar paciente
* alterar dados da conta de médico e paciente conforme a necessidade


Se o medicamento não tiver fim definido ou não acabou ainda marcar como desativado para sinalizar como para

# 3 Tecnologias

* Java
* SpringBoot
* PostgreSQL

# 4 Detalhamento da API


## 4.1 Controle de cadastro de medicamentos
* [POST] Inserir novo medicamento
* [GET] Listar todos os medicamentos
* [GET] Listar um medicamentos
* [PATCH] Alterar Dados de um medicamento (nome)
* [DELETE] Remover um medicamento


### 4.1.1 Requisição: Inserir medicamento (Paciente)
    [POST]/medicamento
```json
{
    "nome": "Dipirona Monohidratada"
}
```

### 4.1.2 Requisição: Ler medicamentos
    [GET]/medicamento  
Parametros:
```
page int
count int
sort list<string>
filter map<string, string>
```

### 4.1.3 Requisição: Ler um medicamento
    [GET]/medicamento/{id}

### 4.1.4 Requisição: Alterar um medicamento (paciente)
    [PATCH]/medicamento/{id}
```json
{
    "nome": "Dipirona Sódica"
}
```

### 4.1.5 Requisição: Remover um medicamento
    [DELETE]/medicamento/{id}

## 4.2 Controle de cadastro de médicos e pacientes
Endpoints:
* [POST] Inserir médico ou paciente
* [POST] Login de médico ou paciente
* [GET] Listar médicos
* [GET] Listar pacientes
* [GET] Listar um médico ou paciente
* [PUT] Alterar médico ou paciente
* [DELETE] Remover médico ou paciente

### 4.2.1 Requisição: Inserir médico ou paciente
    [POST]/auth/signin
```json
{
    "username": "ramon.venson",
    "email": "ramon.venson@satc.edu.br",
    "password": "godot_java",
    "fullName": "Ramon Venson",
    "birthDate": "1994-12-25"
    "type": 0
}
```
### 4.2.2 Requisição: Inserir médico ou paciente
    [POST]/auth/login
```json
{
    "username": "ramon.venson",
    "password": "godot_java",
}
```

### 4.2.3 Requisição: Listar médicos 
    [GET]/medico
parametros
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.2.4 Requisição: Listar pacientes 
    [GET]/paciente
parametros
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.2.5 Requisição: Listar médico ou paciente 
    [GET]/usuario/{id}

### 4.2.6 Requisição: Alterar médico ou paciente
    [PUT]/usuario/{id}
```json
{
    "username": "ramon.venson",
    "email": "ramon.venson@satc.edu.br",
    "password": "godot_java",
    "fullName": "Ramon Venson",
    "birthDate": "1970-11-25"
    "type": 1
}
```

### 4.2.7 Requisição: Remover médico ou paciente
    [DELETE]/user/{id}
    

## 4.3 Controle de disponibilidade dos médicos
Endpoints:
* [POST] Inserir disponibilidade de médico
* [GET] Listar disponibilidade de médico
* [DELETE] Deletar disponibilidade de médico

### 4.3.1 Requisição: Inserir disponibilidade de médico
    [POST]/disponibilidade
```json
{
    "medicId": 1,
    "diaSemana": 1,
    "horário": "13:30",
    "idDiaSemanaHorario": 1
}
```
    
### 4.3.2 Requisição: Listar disponibilidade de médico
    [GET]/disponibilidade/{id-medico}
parametros
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```
    
### 4.3.3 Requisição: Deletar disponibilidade de médico
    [DELETE]/disponibilidade/{id}

## 4.4 Controle de Consultas para Paciente
Endpoints:
* [POST] Agendar consulta
* [GET] Listar consultas
* [GET] Listar uma consulta
* [PATCH] Alterar data/horario da consulta
* [DELETE] Cancelar consulta

### 4.4.1 Requisição: Agendar consulta
    [POST]/consulta/{id-medico}
```json
{
    "patientId": 1,
    "availabilityId": 1,
    "local": "São João Batista"
}
```

### 4.4.2 Requisição: Listar consultas por paciente
    [GET]/consulta/{id-paciente}
parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.4.2 Requisição: Listar consultas por médico
    [GET]/consulta/{id-medico}
parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.4.4 Requisição: Alterar data/horario da consulta
    [PATCH]/consulta/{id-consulta}
```json
{
    "availabilityId": 2
}
```

### 4.4.5 Requisição: Cancelar consulta
    [DELETE]/consulta/{id-consulta}

## 4.5 Controle de prescrições
Endpoints:
* [POST] Inserir nova prescrição
* [GET] Listar todos as prescrições
* [GET] Listar uma prescrição
* [PUT] Alterar Dados de uma prescrição (data, hora, quantidade)
* [DELETE] Remover uma prescrição
  
### 4.5.1 Requisição: Inserir prescrição (médico)
[POST]/prescricao
```json
{
    "patientId": 1,        
    "doctorId": 1,
    "medicineId": 1,
    "timeBetweenIntakes": "06:00:00",
    "amountToTake": 1
}
```

### 4.5.2 Requisição: Ler prescrições (médico)
    [GET]/prescricao/paciente/{id-paciente}?   
Parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.5.3 Requisição: Ler uma prescrição (médico)
    [GET]/prescricao/{id-prescricao}

### 4.5.4 Requisição: Alterar uma prescrição (médico)
    [PUT]/prescricao/{id-prescricao}
```json
{
     "patientId": 1,        
    "doctorId": 1,
    "medicineId": 1,
    "timeBetweenIntakes": "06:00:00",
    "amountToTake": 1
}
```

### 4.5.5 Requisição: Remover uma prescrição (médico)
    [DELETE]/prescricao/{id-prescricao}


