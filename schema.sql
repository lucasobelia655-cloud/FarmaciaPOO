CREATE TABLE IF NOT EXISTS producto (
    codigo TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL CHECK (precio > 0),
    stock INTEGER NOT NULL CHECK (stock >= 0),
    tipo TEXT NOT NULL CHECK (tipo IN ('LIBRE','CONTROLADO','CURACION')),
    lote TEXT,
    fecha_caducidad TEXT,
    activo INTEGER NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS venta (
    folio INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL,
    subtotal REAL NOT NULL,
    impuestos REAL NOT NULL,
    total REAL NOT NULL,
    metodo_pago TEXT NOT NULL CHECK (metodo_pago IN ('EFECTIVO','TARJETA')),
    monto_recibido REAL,
    cambio REAL,
    ultimos4 TEXT,
    autorizacion TEXT
);

CREATE TABLE IF NOT EXISTS detalle_venta (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    folio_venta INTEGER NOT NULL REFERENCES venta(folio),
    codigo_producto TEXT NOT NULL REFERENCES producto(codigo),
    cantidad INTEGER NOT NULL CHECK (cantidad > 0),
    precio_unitario REAL NOT NULL,
    por_empaque INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS receta (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    folio_venta INTEGER NOT NULL REFERENCES venta(folio),
    medico TEXT NOT NULL,
    cedula TEXT NOT NULL,
    folio_receta TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS movimiento_inventario (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigo_producto TEXT NOT NULL REFERENCES producto(codigo),
    tipo TEXT NOT NULL CHECK (tipo IN ('ENTRADA','SALIDA','AJUSTE')),
    cantidad INTEGER NOT NULL,
    fecha TEXT NOT NULL,
    motivo TEXT
);