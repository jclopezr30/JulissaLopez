Create table categoria(
idcategoria integer primary key identity,
nombre nvarchar(50), 
descripcion nvarchar(50),
estado  BIT DEFAULT 1 );

create table articulo(
idarticulo integer NOT NULL,
idcategoria integer NOT NULL,
codigo nvarchar(50),
nombre nvarchar(50), 
precio nvarchar(20),
CONSTRAINT pk_articulo PRIMARY KEY(idcategoria ,idarticulo),
CONSTRAINT fk_categoria_art FOREIGN key (idcategoria) references categoria (idcategoria)
);
