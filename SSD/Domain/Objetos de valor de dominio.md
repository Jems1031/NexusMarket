# Objetos de valor de dominio

## Introducción

Los objetos de valor representan conceptos del dominio de NexusMarket que no poseen una identidad propia y se definen mediante los valores que contienen.

Permiten representar de forma controlada roles, estados, tipos y otras características del sistema, evitando el uso de cadenas de texto arbitrarias.

Los objetos de valor se utilizan principalmente para representar:

- Roles de los usuarios.
- Estados de los usuarios.
- Estados comerciales de los compradores.
- Tipos y estados de los productos.
- Estados de los pedidos.
- Estados de los carritos.
- Tipos de bodegas.
- Tipos de movimientos de inventario.
- Direcciones de entrega.

---

# Jerarquía de objetos de valor

```text
DomainCatalog
│
├── RolUsuario
├── EstadoUsuario
├── EstadoComercial
├── TipoProducto
├── EstadoProducto
├── EstadoPedido
├── EstadoCarrito
├── TipoBodega
└── TipoMovimientoInventario
```

Direccion es un objeto de valor estructurado y no pertenece a los catálogos anteriores.

---

# DomainCatalog

## Descripción

Representa la base común para los conceptos del negocio que poseen valores controlados por NexusMarket.

No representa una entidad del dominio y no puede utilizarse de manera independiente. Su propósito es proporcionar los datos comunes de los catálogos del sistema.

## Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| code | String | Código único que identifica el valor dentro del catálogo. |
| name | String | Nombre legible del valor. |
| description | String | Descripción funcional del valor. |

## Características

- Es inmutable.
- Sus valores son controlados por el dominio.
- No debe utilizarse una cadena arbitraria para representar roles, estados o tipos.
- Los valores deben mantenerse consistentes con las reglas de NexusMarket.

---

# RolUsuario

## Descripción

Representa el rol que determina las responsabilidades y permisos de un usuario dentro de NexusMarket.

Cada usuario posee un único rol.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| COMPRADOR | Comprador | Persona que adquiere productos publicados. |
| VENDEDOR | Vendedor | Responsable de registrar y administrar sus productos. |
| OPERADOR_LOGISTICO | Operador Logístico | Encargado de la operación física de bodegas y despachos. |
| ADMINISTRADOR | Administrador | Responsable de la administración de vendedores y bodegas. |
| SUPERVISOR | Supervisor | Perfil encargado de consulta y seguimiento operativo. |

---

# EstadoUsuario

## Descripción

Representa la condición operativa actual de un usuario dentro de NexusMarket.

Cada usuario debe poseer un estado.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| ACTIVO | Activo | El usuario se encuentra habilitado para operar dentro del sistema. |
| BLOQUEADO | Bloqueado | El usuario se encuentra restringido para realizar operaciones. |

La especificación actual solo define los estados Activo y Bloqueado. No se incluyen estados adicionales.

---

# EstadoComercial

## Descripción

Representa la condición comercial de un comprador dentro de NexusMarket.

El comprador debe poseer un estado comercial.

## Hereda de

DomainCatalog

## Valores permitidos

La especificación define el concepto de estado comercial, pero no establece valores concretos.

Por este motivo, no se definen valores para EstadoComercial hasta contar con reglas funcionales adicionales.

---

# TipoProducto

## Descripción

Representa la clasificación principal de los productos comercializados en NexusMarket.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| FISICO | Físico | Producto que requiere inventario y proceso de despacho. |
| DIGITAL | Digital | Producto cuya entrega se realiza después de la confirmación del pago. |

---

# EstadoProducto

## Descripción

Representa el estado de publicación y disponibilidad comercial de un producto dentro del catálogo de NexusMarket.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| PUBLICADO | Publicado | El producto se encuentra visible y disponible dentro del catálogo. |
| SUSPENDIDO | Suspendido | El producto no se encuentra disponible temporalmente para comercialización. |
| DESCONTINUADO | Descontinuado | El producto ha dejado de comercializarse. |

---

# EstadoPedido

## Descripción

Representa el estado actual del ciclo de vida de un pedido dentro de NexusMarket.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| CARRITO | Carrito | Productos seleccionados provisionalmente por el comprador. |
| PENDIENTE_PAGO | Pendiente de pago | El pedido está esperando confirmación financiera. |
| PAGADO | Pagado | El pago ha sido confirmado. |
| DESPACHADO | Despachado | El pedido salió físicamente de la bodega. |
| ENTREGADO_FINALIZADO | Entregado / Finalizado | La entrega fue confirmada y el pedido concluyó satisfactoriamente. |

## Ciclo de vida

```text
CARRITO
   │
   ▼
PENDIENTE_PAGO
   │
   ▼
PAGADO
   │
   ▼
DESPACHADO
   │
   ▼
ENTREGADO_FINALIZADO
```

Un pedido finalizado no puede modificarse.

---

# EstadoCarrito

## Descripción

Representa la condición actual del carrito de compras utilizado por un comprador.

## Hereda de

DomainCatalog

## Valores permitidos

La especificación actual no define valores concretos para el estado de un carrito.

Por este motivo, no se definen valores para EstadoCarrito hasta contar con reglas funcionales adicionales.

---

# TipoBodega

## Descripción

Representa la clasificación de las bodegas utilizadas para administrar el inventario físico dentro de NexusMarket.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| MARKETPLACE | Bodega del Marketplace | Espacio físico de almacenamiento administrado por NexusMarket. |
| VENDEDOR | Bodega del Vendedor | Espacio físico de almacenamiento asociado con un vendedor. |

---

# TipoMovimientoInventario

## Descripción

Representa el tipo de movimiento realizado sobre las existencias de un producto dentro de una bodega.

## Hereda de

DomainCatalog

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| INGRESO | Ingreso | Entrada de existencias al inventario. |
| RESERVA | Reserva | Separación de existencias para una operación comercial. |
| SALIDA_POR_VENTA | Salida por venta | Reducción de existencias debido a una venta. |
| AJUSTE | Ajuste | Modificación de existencias debido a una corrección de inventario. |
| DEVOLUCION | Devolución | Movimiento relacionado con productos devueltos. |

## Regla de negocio

Las existencias de inventario no pueden ser negativas.

No se puede reservar inventario inexistente.

---

# Direccion

## Descripción

Representa la ubicación utilizada para realizar las entregas de los compradores.

Direccion es un objeto de valor estructurado. Su significado depende de los datos que contiene y no de un identificador propio.

Puede utilizarse como dirección principal de un comprador, dirección adicional o dirección de entrega de un pedido.

## Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| calle | String | Calle, carrera, avenida u otra referencia principal de ubicación. |
| numero | String | Número correspondiente a la dirección. |
| complemento | String | Información adicional de la ubicación, cuando exista. |
| ciudad | String | Ciudad donde se encuentra la dirección. |
| departamento | String | Departamento o región correspondiente. |
| codigoPostal | String | Código postal, cuando corresponda. |

## Características

- No posee identidad propia.
- Se define mediante sus valores.
- Es inmutable.
- Puede utilizarse en procesos de entrega.

---

# Relación de los objetos de valor con las entidades

```text
Usuario
   │
   ├── rol ───────────────> RolUsuario
   │
   └── estado ────────────> EstadoUsuario

Comprador
   │
   ├── estadoComercial ──> EstadoComercial
   │
   └── direcciones ──────> Direccion

Producto
   │
   ├── tipo ─────────────> TipoProducto
   │
   └── estado ───────────> EstadoProducto

Pedido
   │
   ├── estado ───────────> EstadoPedido
   │
   └── direccionEntrega ─> Direccion

Bodega
   │
   └── tipo ─────────────> TipoBodega

Inventario
   │
   └── movimiento ───────> TipoMovimientoInventario
```

---

# Clasificación de los objetos de valor

| Concepto | Tipo | Valores definidos |
|---|---|---|
| RolUsuario | Catálogo de dominio | Sí |
| EstadoUsuario | Catálogo de dominio | Sí |
| EstadoComercial | Catálogo de dominio | No |
| TipoProducto | Catálogo de dominio | Sí |
| EstadoProducto | Catálogo de dominio | Sí |
| EstadoPedido | Catálogo de dominio | Sí |
| EstadoCarrito | Catálogo de dominio | No |
| TipoBodega | Catálogo de dominio | Sí |
| TipoMovimientoInventario | Catálogo de dominio | Sí |
| Direccion | Objeto de valor estructurado | No aplica |

---

# Conceptos pendientes de definición

Los siguientes aspectos requieren una definición funcional adicional:

- Valores concretos de EstadoComercial.
- Valores concretos de EstadoCarrito.
- Posibles estados adicionales de EstadoUsuario.
- Reglas de validación específicas para Direccion.
- Objetos de valor necesarios para otros dominios de NexusMarket.

---

# Principios aplicados

- Los objetos de valor no poseen identidad propia.
- Los objetos de valor se definen mediante sus valores.
- Los objetos de valor son inmutables.
- Los roles, estados y tipos se representan mediante conceptos controlados.
- No se inventan valores que no han sido definidos por las reglas del negocio.
