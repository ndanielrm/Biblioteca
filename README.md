#  Sistema de Gestión de Biblioteca

Proyecto integrador de **Programación II (2025)**.  
El objetivo es desarrollar un programa en Java (modo consola) que modele la gestión básica de una biblioteca, aplicando los conceptos de programación estructurada, POO, colecciones y manejo de excepciones.

---

##  **Descripción del Proyecto**

El sistema permite administrar libros y usuarios de una biblioteca, pudiendo realizar las siguientes operaciones:

<<<<<<< HEAD
- Agregar nuevos libros   
- Listar todos los libros disponibles  
- Buscar libros por título
=======
- Agregar nuevos libros  
- Listar todos los libros disponibles    
>>>>>>> rama-nicolas
- Eliminar o modificar libros  
- Mostrar los libros actualmente prestados  
- Editar la información de un libro existente, con manejo de excepciones personalizadas

---

##  **Estructura del Proyecto**

Biblioteca/  
│  
├── src/  
│ ├── Main.java  
│ ├── modelos/  
│ │ ├── Libro.java  
│ │ └── Usuario.java  
│ ├── servicios/  
│ │ └── BibliotecaService.java  
│ └── excepciones/  
│   └── ElementoNoEncontradoException.java  
│  
└── README.md  

---

---

## **Integrantes del equipo**

| Nombre completo              | Rol / Función principal   | Rama en Git |  
|------------------------------|---------------------------|-------------|  
| Nicolás Daniel Roman Moreno  | Crear métodos y funciones | rama-nicolas|  
| Matias Chazarreta            | Crear métodos y funciones | rama-matias |

---
---
## **Cosas a Agregar o Faltantes**

+La idea sería que en "Data" haya unos libros cargados así podemos visualizar ya una lista pre cargada con stock y poder aumentar o disminuir ese stock.

+Agregar exepciones en caso de cualquier error.