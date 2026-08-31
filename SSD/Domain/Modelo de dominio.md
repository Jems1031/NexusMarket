# Modelo de dominio

## Introducción

El modelo de dominio representa los conceptos principales del negocio de **NexusMarket** relacionados con los siguientes dominios:

- Administración de usuarios.
- Gestión de compradores.

El modelo describe las entidades, clases dependientes, atributos, relaciones y reglas de negocio del sistema.

Los objetos de valor, como roles, estados y direcciones, se documentan por separado en el documento **Objetos de valor de dominio**.

---

# Dominios incluidos

## Administración de usuarios

Este dominio representa a los usuarios registrados que interactúan con NexusMarket.

Cada usuario posee información de identificación, un rol y un estado operativo.

### Conceptos principales

- Usuario
- Rol de usuario
- Estado de usuario

## Gestión de compradores

Este dominio representa a los usuarios que participan directamente en el proceso comercial como compradores.

El comprador posee información de entrega, un carrito de compras y pedidos asociados.

### Conceptos principales

- Comprador
- Dirección
- Carrito
- Ítem del carrito
- Pedido
- Ítem del pedido
- Estado comercial
- Estado del carrito
- Estado del pedido

---

# Estructura de las clases de dominio

No existe herencia entre `Usuario` y `Comprador`.

Un comprador no representa una especialización de un usuario; ambos son conceptos diferentes dentro del dominio y se relacionan mediante una asociación.

```text
Usuario

Comprador
├── Carrito
│   └── ItemCarrito
│
└── Pedido
    └── ItemPedido
```

Las relaciones principales del dominio son las siguientes:

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

Un `Usuario` puede estar asociado con un `Comprador`.

```text
Usuario
   │
   └── asociado a ──> Comprador
```

## Comprador - Carrito

Un `Comprador` posee un `Carrito` para administrar los productos que desea adquirir.

Un carrito pertenece a un único comprador.

```text
Comprador
   │
   └── posee ──> Carrito
```

## Carrito - ItemCarrito

Un `Carrito` contiene los elementos seleccionados por el comprador.

Cada `ItemCarrito` representa un producto y la cantidad seleccionada.

```text
Carrito
   │
   └── contiene ──> ItemCarrito
```

## Comprador - Pedido

Un `Comprador` puede realizar pedidos dentro de NexusMarket.

Un pedido pertenece a un único comprador.

```text
Comprador
   │
   └── realiza ──> Pedido
```

## Pedido - ItemPedido

Un `Pedido` contiene los productos incluidos en una compra.

Cada `ItemPedido` representa un producto, su cantidad y su precio unitario al momento de realizar el pedido.

```text
Pedido
   │
   └── contiene ──> ItemPedido
```

---

# Entidades y clases del dominio

## Usuario

### Descripción

Representa a una persona registrada y autorizada para interactuar con NexusMarket.

Cada usuario posee una identidad propia, información básica de identificación, un correo electrónico, un rol y un estado.

### Tipo

Entidad concreta.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| identificador | String | Identificador único del usuario dentro de NexusMarket. |
| nombreCompleto | String | Nombre completo del usuario. |
| correoElectronico | String | Correo electrónico utilizado para identificación y comunicación. |
| rol | RolUsuario | Rol que determina las responsabilidades del usuario. |
| estado | EstadoUsuario | Estado operativo actual del usuario. |

### Relaciones

- Un `Usuario` posee un `RolUsuario`.
- Un `Usuario` posee un `EstadoUsuario`.
- Un `Usuario` puede estar asociado con un `Comprador`.

---

## Comprador

### Descripción

Representa a un usuario de NexusMarket que participa en el sistema como comprador.

El comprador se relaciona con un `Usuario`, pero no hereda de él.

### Tipo

Entidad concreta.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| usuario | Usuario | Usuario del sistema asociado al comprador. |
| direccionPrincipal | Direccion | Dirección principal utilizada para las entregas. |
| direccionesAdicionales | `List<Direccion>` | Direcciones adicionales registradas por el comprador. |
| estadoComercial | EstadoComercial | Estado comercial actual del comprador. |

### Relaciones

- Un `Comprador` está asociado con un `Usuario`.
- Un `Comprador` posee una dirección principal.
- Un `Comprador` puede poseer direcciones adicionales.
- Un `Comprador` posee un `EstadoComercial`.
- Un `Comprador` posee un `Carrito`.
- Un `Comprador` puede realizar uno o más `Pedido`.

---

## Carrito

### Descripción

Representa el carrito de compras utilizado por un comprador para seleccionar productos antes de realizar un pedido.

### Tipo

Entidad concreta.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| identificador | String | Identificador único del carrito. |
| comprador | Comprador | Comprador propietario del carrito. |
| items | `List<ItemCarrito>` | Elementos contenidos en el carrito. |
| estado | EstadoCarrito | Estado actual del carrito. |

### Relaciones

- Un `Carrito` pertenece a un `Comprador`.
- Un `Carrito` contiene cero o más `ItemCarrito`.
- Cada `ItemCarrito` representa un producto seleccionado.
- Un `Carrito` puede utilizarse para generar un `Pedido`.

---

## ItemCarrito

### Descripción

Representa un producto seleccionado dentro de un carrito y la cantidad que el comprador desea adquirir.

### Tipo

Clase dependiente.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| producto | Producto | Producto seleccionado por el comprador. |
| cantidad | Integer | Número de unidades seleccionadas. |

### Relaciones

- Un `ItemCarrito` pertenece a un `Carrito`.
- Un `ItemCarrito` referencia un `Producto`.

---

## Pedido

### Descripción

Representa una solicitud de compra realizada por un comprador dentro de NexusMarket.

Un pedido conserva la información de los productos adquiridos, el comprador, la dirección de entrega, el estado y el valor total.

### Tipo

Entidad concreta.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| identificador | String | Identificador único del pedido. |
| comprador | Comprador | Comprador que realizó el pedido. |
| items | `List<ItemPedido>` | Productos incluidos en el pedido. |
| fechaCreacion | LocalDateTime | Fecha y hora de creación del pedido. |
| estado | EstadoPedido | Estado actual del pedido. |
| direccionEntrega | Direccion | Dirección seleccionada para la entrega. |
| total | BigDecimal | Valor total de los productos incluidos. |

### Relaciones

- Un `Pedido` pertenece a un `Comprador`.
- Un `Pedido` contiene uno o más `ItemPedido`.
- Un `Pedido` posee una dirección de entrega.
- Un `Pedido` posee un `EstadoPedido`.

---

## ItemPedido

### Descripción

Representa un producto incluido en un pedido, junto con la cantidad solicitada y el precio unitario registrado al momento de la compra.

### Tipo

Clase dependiente.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| producto | Producto | Producto incluido en el pedido. |
| cantidad | Integer | Número de unidades solicitadas. |
| precioUnitario | BigDecimal | Precio del producto al momento de realizar la compra. |

### Relaciones

- Un `ItemPedido` pertenece a un `Pedido`.
- Un `ItemPedido` referencia un `Producto`.

---

## Producto

### Descripción

`Producto` es un concepto relacionado con el proceso de compra, ya que `ItemCarrito` e `ItemPedido` deben hacer referencia al producto seleccionado o comprado.

La definición completa de `Producto` pertenece a otro dominio funcional de NexusMarket y se realizará posteriormente.

### Tipo

Entidad de otro dominio.

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

# Reglas de negocio

## Administración de usuarios

1. Cada usuario debe poseer un identificador único.
2. El nombre completo del usuario es obligatorio.
3. El correo electrónico del usuario es obligatorio.
4. El correo electrónico debe ser único dentro de la plataforma.
5. Cada usuario debe tener un único rol.
6. Cada usuario debe tener un estado.

## Gestión de compradores

1. Un comprador debe estar asociado con un usuario.
2. Un comprador debe poseer una dirección principal.
3. Un comprador puede registrar direcciones adicionales.
4. Un comprador debe poseer un estado comercial.
5. Un comprador posee un carrito de compras.
6. Un comprador puede realizar pedidos cuando se encuentre habilitado para comprar.

## Carrito

1. Un carrito pertenece a un único comprador.
2. Un carrito puede contener cero o más elementos.
3. Cada elemento del carrito debe representar un producto.
4. La cantidad de un producto debe ser válida.

## Pedido

1. Un pedido pertenece a un único comprador.
2. Un pedido debe contener los productos seleccionados para la compra.
3. Cada pedido posee un estado que representa su ciclo de vida.
4. Un pedido posee una dirección de entrega.
5. Un pedido debe conservar el precio unitario de cada producto al momento de la compra.

---

# Clasificación de conceptos

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

# Herencia

Dentro de los dominios de Administración de usuarios y Gestión de compradores no se utiliza herencia entre las entidades principales.

La relación entre `Usuario` y `Comprador` es una asociación.

```text
Usuario
   │
   └── asociación ──> Comprador
```

No existe la siguiente relación:

```text
Usuario
   │
   └── herencia ──> Comprador
```

---

# Resumen

El modelo de dominio de NexusMarket está compuesto, en esta etapa, por las entidades `Usuario`, `Comprador`, `Carrito` y `Pedido`.

`ItemCarrito` e `ItemPedido` son clases dependientes de `Carrito` y `Pedido`, respectivamente.

Los roles, estados y direcciones se representan mediante objetos de valor y se documentan por separado.
