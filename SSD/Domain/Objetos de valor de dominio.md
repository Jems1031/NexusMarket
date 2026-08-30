# Objetos de valor de dominio

## Introducción

Los Objetos de Valor representan conceptos del dominio de NexusMarket que no poseen una identidad propia, sino que se definen por los valores que contienen.

Estos conceptos permiten representar de manera controlada los roles, estados, tipos y demás características utilizadas por las entidades del sistema.

Los Objetos de Valor ayudan a evitar el uso de cadenas de texto o valores primitivos dispersos dentro del sistema y permiten mantener consistencia en las reglas del negocio.

El modelo de NexusMarket utiliza Objetos de Valor principalmente para representar:

- Roles de los usuarios.
- Estados de los usuarios.
- Estados comerciales de los compradores.
- Estados de los productos.
- Tipos de productos.
- Estados de los pedidos.
- Estados de los carritos.
- Tipos de bodegas.
- Movimientos de inventario.

La especificación funcional establece que cada usuario debe tener un único rol y un estado operativo definido. También establece estados y clasificaciones específicas para productos, inventario y pedidos. fileciteturn2file0L114-L135 fileciteturn2file0L165-L178

---

# Jerarquía de Objetos de Valor

```text
DomainCatalog (Abstract)
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

---

# DomainCatalog (Abstract)

## Descripción

Representa una abstracción para los conceptos del negocio que poseen un conjunto de valores controlados por NexusMarket.

Los catálogos permiten evitar el uso de valores arbitrarios y centralizar los conceptos que forman parte de las reglas del negocio.

`DomainCatalog` no representa una entidad concreta y no posee una identidad independiente dentro del negocio.

Esta clase no puede ser instanciada directamente.

## Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| code | String | Código único que identifica el valor dentro del catálogo. |
| name | String | Nombre legible del valor del catálogo. |
| description | String | Descripción funcional del concepto. |

## Características

- Es inmutable.
- Sus valores son controlados por el dominio.
- La igualdad se determina por sus valores.
- No debe utilizarse una cadena arbitraria para representar conceptos controlados.
- Los valores deben mantenerse consistentes con las reglas funcionales de NexusMarket.

---

# RolUsuario

## Descripción

Representa el rol que determina las responsabilidades y permisos de un usuario dentro de NexusMarket.

La especificación establece que cada participante desempeña un único rol dentro del sistema y únicamente puede interactuar con la información correspondiente a sus funciones. fileciteturn2file0L79-L92

El rol es obligatorio y debe ser único por usuario. fileciteturn2file0L114-L135

## Hereda de

`DomainCatalog`

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

La especificación establece que el usuario debe contar con un estado obligatorio y que este debe pertenecer a un catálogo definido. fileciteturn2file0L128-L135

## Hereda de

`DomainCatalog`

## Valores permitidos

La especificación funcional menciona explícitamente los estados `Activo` y `Bloqueado`, pero no presenta un catálogo completo de estados de usuario.

Por esta razón, únicamente se documentan los valores soportados explícitamente por la especificación.

| Código | Nombre | Descripción |
|---|---|---|
| ACTIVO | Activo | El usuario se encuentra habilitado para operar dentro del sistema. |
| BLOQUEADO | Bloqueado | El usuario se encuentra restringido para realizar operaciones. |

> Nota: La especificación no define otros estados concretos de usuario. No se agregan valores adicionales para evitar inventar reglas que no aparecen en el documento funcional.

---

# EstadoComercial

## Descripción

Representa la condición comercial de un comprador dentro de NexusMarket.

El estado comercial determina la condición del comprador para participar en procesos de compra.

La especificación establece que el comprador debe tener obligatoriamente un estado comercial. fileciteturn2file0L136-L150

## Hereda de

`DomainCatalog`

## Valores permitidos

La especificación funcional define el concepto de `Estado comercial`, pero no proporciona los valores concretos que puede asumir.

Por esta razón, el catálogo queda definido conceptualmente, pero sus valores específicos deberán establecerse cuando el negocio los determine.

| Código | Nombre | Descripción |
|---|---|---|
| Pendiente de definición | Pendiente de definición | Estado comercial definido posteriormente por las reglas específicas del negocio. |

> Nota: No se agregan valores como `ACTIVO`, `BLOQUEADO` o `INACTIVO` porque estos no fueron definidos explícitamente para el estado comercial del comprador en la especificación proporcionada.

---

# TipoProducto

## Descripción

Representa la clasificación principal de los productos comercializados en NexusMarket.

El catálogo diferencia entre productos físicos y productos digitales.

Los productos físicos requieren inventario y despacho, mientras que los productos digitales tienen entrega inmediata después del pago. fileciteturn2file0L161-L168

## Hereda de

`DomainCatalog`

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| FISICO | Físico | Producto que requiere inventario y proceso de despacho. |
| DIGITAL | Digital | Producto cuya entrega se realiza inmediatamente después del pago. |

---

# EstadoProducto

## Descripción

Representa el estado actual de publicación y disponibilidad comercial de un producto dentro del catálogo de NexusMarket.

La especificación define los estados `Publicado`, `Suspendido` y `Descontinuado`. fileciteturn2file0L165-L172

## Hereda de

`DomainCatalog`

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

El pedido representa el compromiso comercial formal y su ciclo de vida constituye uno de los procesos centrales del sistema. fileciteturn2file0L179-L187

## Hereda de

`DomainCatalog`

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| CARRITO | Carrito | Productos seleccionados provisionalmente por el comprador. |
| PENDIENTE_PAGO | Pendiente de Pago | El pedido está esperando confirmación financiera. |
| PAGADO | Pagado | El pago ha sido confirmado y puede iniciar el proceso de alistamiento. |
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

La especificación establece que un pedido finalizado no podrá ser modificado bajo ninguna circunstancia. fileciteturn2file0L197-L203

---

# EstadoCarrito

## Descripción

Representa la condición actual del carrito de compras utilizado por un comprador.

El carrito forma parte del proceso de compra del Marketplace y permite seleccionar productos antes de confirmar el pedido. La especificación incluye explícitamente la gestión del carrito como uno de los procesos del sistema. fileciteturn2file0L35-L48

## Hereda de

`DomainCatalog`

## Valores permitidos

La especificación funcional no define un catálogo explícito de estados para el carrito.

Por lo tanto, no se establecen valores concretos que no estén soportados por el documento.

| Código | Nombre | Descripción |
|---|---|---|
| PENDIENTE_DE_DEFINICION | Pendiente de definición | Estado pendiente de ser establecido mediante las reglas específicas del dominio. |

> Nota: Los estados del pedido sí están definidos explícitamente en la especificación, pero los estados propios del carrito no. Por esta razón se mantienen separados.

---

# TipoBodega

## Descripción

Representa la clasificación de las bodegas utilizadas para administrar el inventario físico dentro de NexusMarket.

La especificación distingue entre bodegas pertenecientes al Marketplace y bodegas pertenecientes a los vendedores. fileciteturn2file0L152-L160

## Hereda de

`DomainCatalog`

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| MARKETPLACE | Bodega del Marketplace | Espacio físico de almacenamiento administrado por NexusMarket. |
| VENDEDOR | Bodega del Vendedor | Espacio físico de almacenamiento asociado a un vendedor. |

---

# TipoMovimientoInventario

## Descripción

Representa el tipo de movimiento realizado sobre las existencias de un producto dentro de una bodega.

La especificación identifica cinco movimientos de inventario:

- Ingreso.
- Reserva.
- Salida por venta.
- Ajuste.
- Devolución. fileciteturn2file0L173-L178

## Hereda de

`DomainCatalog`

## Valores permitidos

| Código | Nombre | Descripción |
|---|---|---|
| INGRESO | Ingreso | Entrada de existencias al inventario. |
| RESERVA | Reserva | Separación de existencias para una operación comercial. |
| SALIDA_POR_VENTA | Salida por venta | Reducción de existencias debido a una venta. |
| AJUSTE | Ajuste | Modificación de las existencias debido a una corrección de inventario. |
| DEVOLUCION | Devolución | Reingreso o movimiento relacionado con productos devueltos. |

## Regla de negocio

```text
Las existencias de inventario no pueden ser negativas bajo ninguna circunstancia.
```

La especificación establece además que no se puede reservar inventario inexistente o marcado como `Dañado`. fileciteturn2file0L177-L199

---

# Direccion

## Descripción

Representa la ubicación utilizada para realizar las entregas de los compradores.

La dirección se utiliza como información comercial asociada al comprador.

El dominio de Gestión de Compradores establece una dirección principal obligatoria y permite registrar direcciones adicionales opcionales. fileciteturn2file0L136-L150

A diferencia de los catálogos anteriores, `Direccion` se considera un Objeto de Valor estructurado porque su significado depende de los datos que contiene y no de un identificador independiente.

## Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| calle | String | Calle, carrera, avenida u otra referencia principal de ubicación. |
| numero | String | Número correspondiente a la dirección. |
| complemento | String | Información adicional de la ubicación, cuando exista. |
| ciudad | String | Ciudad donde se encuentra la dirección. |
| departamento | String | Departamento o región correspondiente. |
| codigoPostal | String | Código postal cuando corresponda. |

## Características

- No posee identidad propia dentro del dominio.
- Se define mediante sus valores.
- Puede utilizarse como dirección principal de un comprador.
- Puede utilizarse como una dirección adicional de un comprador.
- Puede utilizarse como dirección de entrega de un pedido.
- Debe representar una ubicación válida para los procesos de entrega.

---

# Reglas de Diseño de los Objetos de Valor

## Inmutabilidad

Los Objetos de Valor deben ser inmutables después de su creación.

Una vez creado un Objeto de Valor, sus valores no deben modificarse directamente.

Cuando sea necesario cambiar un valor, debe crearse una nueva instancia.

---

## Igualdad por valor

Los Objetos de Valor se comparan por sus valores y no por una identidad independiente.

Por ejemplo, dos direcciones que contienen exactamente los mismos datos representan el mismo concepto de dirección desde el punto de vista del dominio.

---

## Catálogos controlados

Los conceptos controlados por las reglas del negocio no deben representarse mediante cadenas arbitrarias.

Por ejemplo, no se debería utilizar:

```text
usuario.rol = "Comprador"
```

sino:

```text
usuario.rol : RolUsuario
```

De la misma manera:

```text
usuario.estado : EstadoUsuario

comprador.estadoComercial : EstadoComercial

producto.tipo : TipoProducto

producto.estado : EstadoProducto

pedido.estado : EstadoPedido

inventario.tipoMovimiento : TipoMovimientoInventario
```

---

# Relación de los Objetos de Valor con las Entidades

Los Objetos de Valor se utilizan dentro de las entidades para representar conceptos controlados del negocio.

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
   ├── tipo ──────────────> TipoProducto
   │
   └── estado ───────────> EstadoProducto


Pedido
   │
   ├── estado ───────────> EstadoPedido
   │
   └── direccionEntrega ─> Direccion


Bodega
   │
   └── tipo ──────────────> TipoBodega


Inventario
   │
   └── movimiento ───────> TipoMovimientoInventario
```

---

# Clasificación de los Objetos de Valor

| Concepto | Tipo | Basado en la especificación |
|---|---|---|
| RolUsuario | Catálogo de dominio | Sí |
| EstadoUsuario | Catálogo de dominio | Sí |
| EstadoComercial | Catálogo de dominio | Sí, pero valores no definidos |
| TipoProducto | Catálogo de dominio | Sí |
| EstadoProducto | Catálogo de dominio | Sí |
| EstadoPedido | Catálogo de dominio | Sí |
| EstadoCarrito | Catálogo de dominio | Concepto incluido, valores no definidos |
| TipoBodega | Catálogo de dominio | Sí |
| TipoMovimientoInventario | Catálogo de dominio | Sí |
| Direccion | Objeto de valor estructurado | Sí |

---

# Conceptos pendientes de definición

La especificación funcional proporciona algunos conceptos cuyo nombre existe, pero cuyos valores concretos no están completamente definidos.

Estos conceptos no deben inventarse dentro del modelo.

Los siguientes quedan pendientes de una definición funcional adicional:

- Valores concretos de `EstadoComercial`.
- Valores concretos de `EstadoCarrito`.
- Posibles estados adicionales de `EstadoUsuario`.
- Estructura exacta requerida para una `Direccion`.
- Otros objetos de valor que puedan surgir al desarrollar los dominios restantes.

Esta decisión mantiene el modelo alineado con la especificación funcional disponible y evita agregar reglas de negocio que no hayan sido definidas.

---

# Reglas generales del dominio relacionadas con los Objetos de Valor

- Cada usuario debe tener un único rol dentro del sistema. fileciteturn2file0L188-L196
- El rol del usuario determina sus responsabilidades y permisos.
- El estado del usuario debe pertenecer a un catálogo definido. fileciteturn2file0L128-L135
- El comprador debe tener una dirección principal.
- Las direcciones adicionales son opcionales. fileciteturn2file0L142-L150
- Los productos se clasifican como físicos o digitales. fileciteturn2file0L161-L168
- Los productos pueden encontrarse publicados, suspendidos o descontinuados. fileciteturn2file0L165-L172
- El pedido sigue un ciclo de estados definido por el negocio. fileciteturn2file0L179-L187
- Un pedido finalizado no puede modificarse. fileciteturn2file0L197-L203
- El inventario no puede tener existencias negativas.
- No se puede reservar inventario inexistente o marcado como `Dañado`. fileciteturn2file0L173-L199

---

# Principios DDD aplicados

- Los Objetos de Valor no poseen identidad propia.
- Los Objetos de Valor se definen mediante sus valores.
- Los Objetos de Valor son inmutables.
- Los conceptos comerciales controlados se representan mediante tipos específicos.
- Se evita utilizar cadenas primitivas para representar roles, estados y tipos del negocio.
- Las entidades utilizan Objetos de Valor para representar conceptos controlados.
- Las relaciones entre entidades y Objetos de Valor se representan explícitamente.
- Los valores que no están definidos en la especificación no se inventan.
- La definición de los Objetos de Valor se mantiene alineada con las reglas funcionales de NexusMarket.
