# Domain Model

## Introducción

El modelo de dominio representa los conceptos principales del negocio de **NexusMarket** relacionados con los siguientes dominios:

- **Administración de Usuarios**
- **Gestión de Compradores**

El modelo sigue los principios de la Programación Orientada a Objetos y del **Diseño Dirigido por el Dominio (DDD)**, buscando representar las entidades, responsabilidades, atributos, métodos, relaciones y reglas de negocio del sistema.

En este documento se describen las clases que forman parte del modelo de dominio. Los objetos de valor, como estados, roles y otros conceptos definidos por sus valores, serán documentados posteriormente en la carpeta **Domain Value Objects**.

Las entidades del dominio poseen identidad propia y un ciclo de vida. Las relaciones entre las entidades se representan explícitamente para reflejar las relaciones reales existentes dentro del negocio.

---

# Dominios incluidos

## Dominio 1: Administración de Usuarios

Este dominio se encarga de representar y administrar los usuarios que interactúan con NexusMarket.

El usuario posee información de identificación, un rol y un estado que determinan su participación y sus posibilidades de interacción dentro del sistema.

### Conceptos principales

- Usuario
- Rol del usuario
- Estado del usuario

---

## Dominio 2: Gestión de Compradores

Este dominio representa a los usuarios que participan directamente en el proceso comercial de NexusMarket como compradores.

El comprador puede administrar su información, utilizar un carrito de compras y realizar pedidos.

### Conceptos principales

- Comprador
- Dirección
- Carrito
- ItemCarrito
- Pedido
- ItemPedido
- Estado comercial
- Estado del carrito
- Estado del pedido

---

# Jerarquía y estructura de clases de dominio

En este modelo no se utiliza herencia entre `Usuario` y `Comprador`, debido a que un comprador no representa una especialización de un usuario desde el punto de vista del dominio.

Un comprador está asociado con un usuario.

La estructura principal es:

```text
Usuario

Comprador
├── Carrito
│   └── ItemCarrito
│
└── Pedido
    └── ItemPedido
```

Las relaciones entre las clases son las siguientes:

```text
Usuario
   │
   └── asociado a ─────────> Comprador
                              │
                              ├── posee ──────────> Carrito
                              │                       │
                              │                       └── contiene ──> ItemCarrito
                              │
                              └── realiza ─────────> Pedido
                                                      │
                                                      └── contiene ──> ItemPedido
```

---

# Relaciones de dominio

## Usuario - Comprador

Un `Usuario` puede estar asociado a un `Comprador`.

La relación representa el hecho de que una identidad registrada en NexusMarket puede participar en el sistema como comprador.

```text
Usuario
   │
   └── puede estar asociado a ──> Comprador
```

---

## Comprador - Carrito

Un `Comprador` posee un `Carrito` para administrar los productos que desea adquirir antes de confirmar una compra.

```text
Comprador
   │
   └── posee ──> Carrito
```

Un carrito pertenece a un único comprador.

---

## Carrito - ItemCarrito

Un `Carrito` contiene los elementos seleccionados por el comprador.

Cada `ItemCarrito` representa un producto y la cantidad seleccionada.

```text
Carrito
   │
   └── contiene ──> ItemCarrito
```

---

## Comprador - Pedido

Un `Comprador` puede realizar pedidos dentro de NexusMarket.

```text
Comprador
   │
   └── realiza ──> Pedido
```

Un pedido pertenece a un único comprador.

---

## Pedido - ItemPedido

Un `Pedido` contiene los productos que fueron incluidos en la compra.

Cada `ItemPedido` representa un producto, su cantidad y el precio que tenía en el momento de realizar el pedido.

```text
Pedido
   │
   └── contiene ──> ItemPedido
```

---

# Entidades

## Usuario

### Descripción

Representa a una persona registrada y autorizada para interactuar con NexusMarket.

El usuario constituye una entidad central del dominio de **Administración de Usuarios**, ya que permite identificar a las personas que interactúan con la plataforma.

Cada usuario posee una identidad propia, información básica de identificación, un correo electrónico, un rol y un estado.

### Tipo

**Entidad concreta.**

`Usuario` no es una clase abstracta porque representa directamente a un usuario registrado dentro del sistema.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| identificador | String | Identificador único del usuario dentro de NexusMarket. |
| nombreCompleto | String | Nombre completo del usuario. |
| correoElectronico | String | Correo electrónico utilizado para comunicación e identificación dentro del sistema. |
| rol | RolUsuario | Rol que determina las responsabilidades del usuario dentro del sistema. |
| estado | EstadoUsuario | Estado actual del usuario dentro de NexusMarket. |

### Relaciones

- Un `Usuario` posee un `RolUsuario`.
- Un `Usuario` posee un `EstadoUsuario`.
- Un `Usuario` puede estar asociado a un `Comprador`.
- Un usuario puede realizar las operaciones permitidas de acuerdo con su rol y estado.

### Métodos

| Método | Descripción |
|---|---|
| actualizarNombre(nombreCompleto) | Actualiza el nombre completo del usuario. |
| cambiarCorreo(correoElectronico) | Actualiza el correo electrónico del usuario aplicando las validaciones correspondientes. |
| cambiarRol(rol) | Modifica el rol asignado al usuario de acuerdo con las reglas del sistema. |
| cambiarEstado(estado) | Modifica el estado operativo del usuario. |
| puedeRealizarOperacion() | Determina si el estado y las condiciones del usuario permiten realizar operaciones dentro del sistema. |

---

# Comprador

## Descripción

Representa a un usuario de NexusMarket que participa en el sistema como comprador.

El comprador puede administrar su información de entrega, utilizar un carrito de compras y realizar pedidos.

El comprador mantiene una relación con un `Usuario`, pero no hereda de él, ya que ambos representan conceptos diferentes dentro del dominio.

### Tipo

**Entidad concreta.**

`Comprador` es una entidad porque posee relaciones y comportamiento propio dentro del proceso comercial.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| usuario | Usuario | Usuario del sistema asociado al comprador. |
| direccionPrincipal | Direccion | Dirección principal utilizada por el comprador para sus entregas. |
| direccionesAdicionales | List<Direccion> | Direcciones adicionales registradas por el comprador. |
| estadoComercial | EstadoComercial | Estado comercial actual del comprador. |

### Relaciones

- Un `Comprador` está asociado a un `Usuario`.
- Un `Comprador` posee una dirección principal.
- Un `Comprador` puede registrar direcciones adicionales.
- Un `Comprador` posee un estado comercial.
- Un `Comprador` posee un `Carrito`.
- Un `Comprador` puede realizar múltiples `Pedido`.

### Métodos

| Método | Descripción |
|---|---|
| actualizarDireccionPrincipal(direccion) | Actualiza la dirección principal del comprador. |
| agregarDireccionAdicional(direccion) | Registra una nueva dirección adicional. |
| eliminarDireccionAdicional(direccion) | Elimina una dirección adicional registrada. |
| cambiarEstadoComercial(estado) | Modifica el estado comercial del comprador. |
| puedeComprar() | Determina si el comprador se encuentra habilitado para realizar compras. |
| confirmarPedido() | Confirma la intención de realizar un pedido a partir de los productos seleccionados. |

---

# Carrito

## Descripción

Representa el carrito de compras utilizado por un comprador para seleccionar productos antes de realizar un pedido.

El carrito permite agregar productos, modificar cantidades, eliminar productos y calcular el valor total de los productos seleccionados.

### Tipo

**Entidad concreta.**

`Carrito` posee un ciclo de vida dentro del proceso de compra y pertenece a un comprador específico.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| identificador | String | Identificador único del carrito. |
| comprador | Comprador | Comprador propietario del carrito. |
| items | List<ItemCarrito> | Elementos que contiene actualmente el carrito. |
| estado | EstadoCarrito | Estado actual del carrito. |

### Relaciones

- Un `Carrito` pertenece a un `Comprador`.
- Un `Carrito` contiene cero o más `ItemCarrito`.
- Cada `ItemCarrito` representa un producto seleccionado.
- Un `Carrito` puede utilizarse para generar un `Pedido`.

### Métodos

| Método | Descripción |
|---|---|
| agregarProducto(producto, cantidad) | Agrega un producto al carrito o aumenta la cantidad de un producto existente. |
| modificarCantidad(producto, cantidad) | Modifica la cantidad seleccionada de un producto. |
| eliminarProducto(producto) | Elimina un producto del carrito. |
| vaciar() | Elimina todos los elementos del carrito. |
| calcularTotal() | Calcula el valor total de los productos contenidos en el carrito. |
| estaVacio() | Determina si el carrito no contiene productos. |
| generarPedido() | Genera un pedido utilizando los productos seleccionados en el carrito. |
| cambiarEstado(estado) | Modifica el estado del carrito respetando las reglas del dominio. |

---

# ItemCarrito

## Descripción

Representa un producto seleccionado dentro del carrito y la cantidad que el comprador desea adquirir.

Esta clase permite representar la relación entre el carrito, el producto y la cantidad seleccionada.

### Tipo

**Clase dependiente.**

`ItemCarrito` forma parte del `Carrito` y no representa por sí mismo una entidad comercial independiente.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| producto | Producto | Producto seleccionado por el comprador. |
| cantidad | Integer | Número de unidades seleccionadas del producto. |

### Relaciones

- Un `ItemCarrito` pertenece a un `Carrito`.
- Un `ItemCarrito` referencia un `Producto`.

### Métodos

| Método | Descripción |
|---|---|
| cambiarCantidad(cantidad) | Modifica la cantidad del producto seleccionado. |
| calcularSubtotal(precio) | Calcula el subtotal correspondiente a la cantidad seleccionada. |

---

# Pedido

## Descripción

Representa una solicitud de compra realizada por un comprador dentro de NexusMarket.

El pedido se genera a partir de los productos seleccionados por el comprador y confirmados para realizar una compra.

El pedido mantiene la información necesaria para representar el ciclo de vida de una compra.

### Tipo

**Entidad concreta.**

`Pedido` posee una identidad propia y mantiene un ciclo de vida mediante diferentes estados.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| identificador | String | Identificador único del pedido. |
| comprador | Comprador | Comprador que realizó el pedido. |
| items | List<ItemPedido> | Productos incluidos en el pedido y sus cantidades. |
| fechaCreacion | LocalDateTime | Fecha y hora en la que se creó el pedido. |
| estado | EstadoPedido | Estado actual del pedido. |
| direccionEntrega | Direccion | Dirección seleccionada para realizar la entrega. |
| total | BigDecimal | Valor total de los productos incluidos en el pedido. |

### Relaciones

- Un `Pedido` pertenece a un `Comprador`.
- Un `Pedido` contiene uno o más `ItemPedido`.
- Cada `ItemPedido` representa un producto incluido en el pedido.
- Un `Pedido` posee una dirección de entrega.
- Un `Pedido` posee un estado.
- Un `Pedido` puede cambiar de estado durante su ciclo de vida.

### Métodos

| Método | Descripción |
|---|---|
| calcularTotal() | Calcula el valor total del pedido a partir de sus elementos. |
| cambiarDireccionEntrega(direccion) | Cambia la dirección de entrega cuando las reglas del pedido lo permiten. |
| confirmar() | Confirma el pedido y actualiza su estado. |
| cancelar() | Cancela el pedido cuando las reglas del dominio lo permiten. |
| puedeSerCancelado() | Determina si el pedido puede ser cancelado según su estado actual. |
| estaEntregado() | Determina si el pedido ha alcanzado el estado de entrega. |
| cambiarEstado(estado) | Cambia el estado del pedido respetando las reglas del ciclo de vida. |

---

# ItemPedido

## Descripción

Representa un producto específico incluido dentro de un pedido, junto con la cantidad solicitada y el precio que tenía el producto al momento de realizar la compra.

Permite conservar la información de la compra incluso si posteriormente cambia el precio del producto.

### Tipo

**Clase dependiente.**

`ItemPedido` forma parte de un `Pedido` y no representa una entidad comercial independiente.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| producto | Producto | Producto incluido en el pedido. |
| cantidad | Integer | Número de unidades solicitadas. |
| precioUnitario | BigDecimal | Precio del producto en el momento en que se realizó la compra. |

### Relaciones

- Un `ItemPedido` pertenece a un `Pedido`.
- Un `ItemPedido` referencia un `Producto`.
- Un `Pedido` contiene uno o más `ItemPedido`.

### Métodos

| Método | Descripción |
|---|---|
| cambiarCantidad(cantidad) | Modifica la cantidad solicitada cuando las reglas del pedido lo permiten. |
| calcularSubtotal() | Calcula el subtotal multiplicando el precio unitario por la cantidad. |

---

# Producto

## Descripción

`Producto` aparece como un concepto relacionado con el proceso de compra, ya que tanto `ItemCarrito` como `ItemPedido` necesitan hacer referencia al producto seleccionado o comprado.

Sin embargo, la definición completa de `Producto` no pertenece a los dominios de **Administración de Usuarios** ni **Gestión de Compradores**.

Por esta razón, `Producto` se considera una entidad perteneciente a otro dominio funcional de NexusMarket y su definición completa deberá realizarse cuando se documente dicho dominio.

### Tipo

**Entidad de otro dominio.**

### Uso dentro del modelo

```text
Carrito
   │
   └── ItemCarrito
          │
          └── Producto


Pedido
   │
   └── ItemPedido
          │
          └── Producto
```

---

# Reglas de negocio del dominio

## Administración de Usuarios

1. Cada usuario debe poseer un identificador único.
2. El nombre completo del usuario es obligatorio.
3. El correo electrónico del usuario es obligatorio.
4. El correo electrónico debe ser único dentro de la plataforma.
5. Cada usuario debe tener un único rol.
6. Cada usuario debe tener un estado.
7. Las operaciones que puede realizar un usuario dependen de su rol y estado.

---

## Gestión de Compradores

1. Un comprador debe estar asociado a un usuario.
2. Un comprador debe poseer una dirección principal.
3. Un comprador puede registrar direcciones adicionales.
4. Un comprador debe poseer un estado comercial.
5. Un comprador puede administrar su propio carrito.
6. Un comprador puede realizar pedidos cuando se encuentre habilitado para comprar.
7. Un comprador no puede administrar información perteneciente a otros compradores.

---

## Carrito

1. Un carrito pertenece a un único comprador.
2. Un carrito puede contener cero o más elementos.
3. Cada elemento del carrito debe representar un producto.
4. La cantidad de un producto debe ser válida.
5. El total del carrito corresponde a la suma de los subtotales de sus elementos.
6. Un carrito puede utilizarse para generar un pedido.

---

## Pedido

1. Un pedido pertenece a un único comprador.
2. Un pedido debe contener los productos seleccionados para la compra.
3. Cada pedido posee un estado que representa su ciclo de vida.
4. Los cambios de estado deben respetar las reglas definidas por el dominio.
5. El pedido debe conservar el precio unitario del producto en el momento de la compra.
6. Un pedido posee una dirección de entrega.
7. Un pedido solamente puede ser cancelado cuando su estado lo permita.

---

# Clasificación de los conceptos

| Concepto | Clasificación | Abstracta |
|---|---|---|
| Usuario | Entidad | No |
| Comprador | Entidad | No |
| Carrito | Entidad | No |
| ItemCarrito | Clase dependiente | No |
| Pedido | Entidad | No |
| ItemPedido | Clase dependiente | No |
| Producto | Entidad de otro dominio | No definido |
| RolUsuario | Objeto de valor | No aplica |
| EstadoUsuario | Objeto de valor | No aplica |
| EstadoComercial | Objeto de valor | No aplica |
| EstadoCarrito | Objeto de valor | No aplica |
| EstadoPedido | Objeto de valor | No aplica |
| Direccion | Objeto de valor | No aplica |

---

# Herencia de las clases

Dentro de los dominios de **Administración de Usuarios** y **Gestión de Compradores** no se identifica una especialización que requiera utilizar herencia entre las entidades principales.

La relación entre `Usuario` y `Comprador` es una **asociación**, no una relación de herencia.

Por lo tanto:

```text
Usuario
   │
   └── asociación ──> Comprador
```

y no:

```text
Usuario
   │
   └── herencia ──> Comprador
```

Esto permite mantener separadas las responsabilidades de administración de identidad y participación comercial.

---

# Arquitectura DDD aplicada al modelo

El modelo utiliza conceptos fundamentales del **Domain-Driven Design (DDD)**.

## Entidades

Las entidades poseen una identidad propia que permite diferenciarlas durante su ciclo de vida.

En este modelo:

- `Usuario`
- `Comprador`
- `Carrito`
- `Pedido`

son entidades del dominio.

---

## Clases dependientes

Las clases `ItemCarrito` e `ItemPedido` existen como parte de sus respectivas entidades principales.

```text
Carrito
   └── ItemCarrito

Pedido
   └── ItemPedido
```

Estas clases representan elementos necesarios para modelar correctamente la composición del carrito y del pedido.

---

## Objetos de valor

Los conceptos que no requieren identidad propia y que se definen mediante sus valores se modelarán como objetos de valor.

Entre ellos se encuentran:

- `RolUsuario`
- `EstadoUsuario`
- `EstadoComercial`
- `EstadoCarrito`
- `EstadoPedido`
- `Direccion`

Estos conceptos serán documentados en la carpeta:

```text
Domain Value Objects
```

---

# Resumen del modelo

El modelo de dominio de NexusMarket para los dominios de **Administración de Usuarios** y **Gestión de Compradores** está compuesto principalmente por las siguientes entidades:

```text
Usuario
   │
   └── Comprador
         │
         ├── Carrito
         │     └── ItemCarrito
         │             └── Producto
         │
         └── Pedido
               └── ItemPedido
                       └── Producto
```

Las entidades representan los conceptos que poseen identidad y comportamiento dentro del negocio.

Los estados, roles y direcciones se manejarán posteriormente como objetos de valor independientes para mantener una separación clara entre entidades y valores del dominio.
