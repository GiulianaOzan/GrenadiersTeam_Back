package com.utn.sprint3;

import com.utn.sprint3.entidades.*;
import com.utn.sprint3.enums.*;
import com.utn.sprint3.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.text.html.HTML.Tag.HEAD;

@SpringBootApplication
public class Sprint3Application {

	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EmpleadoRepository empleadoRepository;
	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	MercadoPagoDatosRepository mercadoPagoDatosRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroGeneralRepository rubroGeneralRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(Sprint3Application.class, args);
		System.out.println("Estoy funcionando");
	}


	@Bean
	CommandLineRunner init(RubroArticuloRepository rubroArticuloRepository1) {
		return args -> {
			System.out.println("ESTOY----FUNCIONANDO");

			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-09";
			String fechaString1 = "2023-11-11";

			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);
			Date fecha1 = formatoFecha.parse(fechaString1);


			//CREAR INSTANCIA DE RUBRO ----------------------------------------------------

			RubroArticulo rubro0 = RubroArticulo.builder()
					.denominacion("Insumos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.estadoAB(EstadoAB.Alta)
					.fechaModificacion(fecha)

					.build();

			RubroArticulo rubro1 = RubroArticulo.builder()
					.denominacion("Insumos hijos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.estadoAB(EstadoAB.Alta)
					.fechaModificacion(fecha)
					.rubroPadre(rubro0)
					.build();

			RubroArticulo rubro2 = RubroArticulo.builder()
					.denominacion("Insumos hijos hijos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.estadoAB(EstadoAB.Alta)
					.fechaModificacion(fecha)
					.rubroPadre(rubro0)
					.build();

			rubroArticuloRepository.save(rubro0);
			rubroArticuloRepository.save(rubro1);
			rubroArticuloRepository.save(rubro2);

			//CREAR UNIDAD DE MEDIDA -------------------------------------------------------

			UnidadMedida unidadMedida1 = UnidadMedida.builder()
					.abreviatura("Kg")
					.denominacion("Insumos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			UnidadMedida unidadMedida2 = UnidadMedida.builder()
					.abreviatura("cm3")
					.denominacion("Insumos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			unidadMedidaRepository.save(unidadMedida1);
			unidadMedidaRepository.save(unidadMedida2);


			// CREAR INSTANCIA DE ARTICULO INSUMO ------------------------------------------

			Articulo_Insumo articuloInsumo1 = Articulo_Insumo.builder()
					.denominacion("Harina 000")
					.precioCompra(500)
					.stockMinimo(8)
					.stockActual(15)
					.urlImagen("Harina.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Articulo_Insumo articuloInsumo2 = Articulo_Insumo.builder()
					.denominacion("Queso cheddar")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(50)
					.urlImagen("Cheddar.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Articulo_Insumo articuloInsumo3 = Articulo_Insumo.builder()
					.denominacion("Mozzarella")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(45)
					.urlImagen("mozza.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Articulo_Insumo articuloInsumo4 = Articulo_Insumo.builder()
					.denominacion("Queso Crema")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(5)
					.urlImagen("QCrema.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Articulo_Insumo articuloInsumo5 = Articulo_Insumo.builder()
					.denominacion("Queso Roquefort")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(1)
					.urlImagen("QRoq.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Articulo_Insumo articuloInsumo6 = Articulo_Insumo.builder()
					.denominacion("Pan")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(150)
					.urlImagen("Pan.jpg")
					.fechaAlta(fecha)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();


			Articulo_Insumo articuloInsumo7 = Articulo_Insumo.builder()
					.denominacion("Queso Muzzarella")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(50)
					.urlImagen("queso.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();


			//Vinculamos el rubro a los articulos ------------------------------------------

			articuloInsumo1.setRubroArticulo(rubro1);
			articuloInsumo2.setRubroArticulo(rubro1);
			articuloInsumo3.setRubroArticulo(rubro1);

			articuloInsumo1.setRubroArticulo(rubro1);
			articuloInsumo2.setRubroArticulo(rubro1);
			articuloInsumo3.setRubroArticulo(rubro1);
			articuloInsumo4.setRubroArticulo(rubro2);
			articuloInsumo5.setRubroArticulo(rubro2);
			articuloInsumo6.setRubroArticulo(rubro2);


			articuloInsumoRepository.save(articuloInsumo1);
			articuloInsumoRepository.save(articuloInsumo2);
			articuloInsumoRepository.save(articuloInsumo3);
			articuloInsumoRepository.save(articuloInsumo4);
			articuloInsumoRepository.save(articuloInsumo5);
			articuloInsumoRepository.save(articuloInsumo6);


			// Vinculamos la unidad medida al articulo -------------------------------------

			articuloInsumo1.setUnidadMedida(unidadMedida1);
			articuloInsumo2.setUnidadMedida(unidadMedida2);
			articuloInsumoRepository.save(articuloInsumo1);
			articuloInsumoRepository.save(articuloInsumo2);


			//	CREAR INSTANCIA RUBRO GRAL -------------------------------------------------

			RubroGeneral rubroGeneral1 = RubroGeneral.builder()
					.denominacion("Manufacturados")
					.estadoAB(EstadoAB.Alta)
					.build();
			RubroGeneral rubroGeneral2 = RubroGeneral.builder()
					.denominacion("Insumos")
					.estadoAB(EstadoAB.Alta)
					.build();

			rubroGeneralRepository.save(rubroGeneral1);
			rubroGeneralRepository.save(rubroGeneral2);

			//CREAR DETALLE ART MANUFACTURADO ----------------------------------------------

			DetalleArticuloManufacturado detalleArticuloManufacturado1 = DetalleArticuloManufacturado.builder()
					.cantidad(5)
					.build();

			DetalleArticuloManufacturado detalleArticuloManufacturado2 = DetalleArticuloManufacturado.builder()
					.cantidad(15)
					.build();

			/*detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado1);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado2);*/

			//CREAR INSTANCIA DE ART MANUFACTU ---------------------------------------------

			ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
					.costo(700)
					.denominacion("Prepizza oregano")
					.descripcion("precalentada")
					.precioVenta(600)
					.tiempoEstimadoCocina(15)
					.urlImagen("Prepiza.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
					.costo(900)
					.denominacion("Pan de papa")
					.descripcion("sin levadura")
					.precioVenta(400)
					.tiempoEstimadoCocina(15)
					.urlImagen("Panpapa.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();


			//VINCULAR DETALLE ART MANU A ART MANUF ---------------------------------------




			//Vinculamos el rubro gral a los articulos manu --------------------------------

			articuloManufacturado1.setRubroGeneral(rubroGeneral1);
			articuloManufacturado2.setRubroGeneral(rubroGeneral1);

			articuloManufacturadoRepository.save(articuloManufacturado1);
			articuloManufacturadoRepository.save(articuloManufacturado2);

			// VINCULAR DETALLE ART MANU CON ARTICULO INSUMO

			detalleArticuloManufacturado1.setArticuloInsumo(articuloInsumo1);
			detalleArticuloManufacturado2.setArticuloInsumo(articuloInsumo2);

			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado1);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado2);

			//CREO CLIENTE -----------------------------------------------------------------

			Cliente cliente1 = Cliente.builder()
					.nombre("Leonel")
					.apellido("Messi")
					.email("leomessi10@gmail.com")
					.telefono("261605548")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Enrique")
					.apellido("Gomez")
					.email("arnaldo10@gmail.com")
					.telefono("261568548")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			//CREO EMPLEADOS ----------------------------------------------------------------


			Empleado empleado1 = Empleado.builder()
					.nombre("Martin")
					.apellido("Lopez")
					.email("Delivery1@gmail.com")
					.telefono(261458755)
					.fechaAlta(fecha)
					.fechaBaja(null)
					.fechaModificacion(fecha1)
					.build();

			Empleado empleado2 = Empleado.builder()
					.nombre("Lucas")
					.apellido("Gomez")
					.email("Cocinero1@gmail.com")
					.telefono(26144774)
					.fechaAlta(fecha1)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			Empleado empleado3 = Empleado.builder()
					.nombre("Martina")
					.apellido("Luna")
					.email("Cajera1@gmail.com")
					.telefono(261877369)
					.fechaAlta(fecha)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			Empleado empleado4 = Empleado.builder()
					.nombre("Tomas")
					.apellido("Gimenez")
					.email("Administrador1@gmail.com")
					.telefono(321144585)
					.fechaAlta(fecha1)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			empleadoRepository.save(empleado1);
			empleadoRepository.save(empleado2);
			empleadoRepository.save(empleado3);
			empleadoRepository.save(empleado4);

			//CREO DOMICILIO ---------------------------------------------------------------

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Avellaneda")
					.codigoPostal(5533)
					.localidad("El Bermejo")
					.pisoDpto(5)
					.numero(22)
					.numeroDpto(3)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Cambiaghi")
					.codigoPostal(8899)
					.localidad("Villa Tulumaya")
					.pisoDpto(7)
					.numero(26)
					.numeroDpto(9)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Patricias Mendocinas")
					.codigoPostal(7744)
					.localidad("Capital")
					.pisoDpto(5)
					.numero(788)
					.numeroDpto(7)
					.fechaAlta(fecha)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			Domicilio domicilio4 = Domicilio.builder()
					.calle("Renato Della Santa")
					.codigoPostal(9887)
					.localidad("Villa Tulumaya")
					.pisoDpto(7)
					.numero(26)
					.numeroDpto(9)
					.fechaAlta(fecha)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			Domicilio domicilio5 = Domicilio.builder()
					.calle("Gabrielli")
					.codigoPostal(8744)
					.localidad("Maipu")
					.pisoDpto(5)
					.numero(55)
					.numeroDpto(5)
					.fechaAlta(fecha1)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			Domicilio domicilio6 = Domicilio.builder()
					.calle("Gral Alvear")
					.codigoPostal(5447)
					.localidad("Lujan")
					.pisoDpto(7)
					.numero(26)
					.numeroDpto(9)
					.fechaAlta(fecha1)
					.fechaBaja(null)
					.fechaModificacion(fecha)
					.build();

			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);
			domicilioRepository.save(domicilio4);
			domicilioRepository.save(domicilio5);
			domicilioRepository.save(domicilio6);

			//CREO USUARIO -----------------------------------------------------------------

			Usuario usuario1 = Usuario.builder()
					.auth0Id("User01")
					.username("Cajero1")
					.rol(Rol.Cajero)
//					.contraseña("Cajero1")
					.email("tilo@gmail.com")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.password(passwordEncoder.encode("desarrollo"))
					.build();

			Usuario usuario2 = Usuario.builder()
					.auth0Id("User02")
					.username("Unknow88")
					.rol(Rol.Cliente)
//					.contraseña("Cliente1")
					.email("Usuario2@gmail.com")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.password(passwordEncoder.encode("user123"))
					.build();

			Usuario usuario3 = Usuario.builder()
					.auth0Id("User03")
//					.username("Unknow88")
					.rol(Rol.Cliente)
//					.contraseña("Cliente2")
					.username("Delivery")
					.rol(Rol.Delivery)
					.email("usuario3@hotmail.com")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.password(passwordEncoder.encode("desarrollo"))

					.build();

			Usuario usuario4 = Usuario.builder()
					.auth0Id("User04")
					.username("Delivery1")
					.rol(Rol.Delivery)
//					.contraseña("Delivery1")
					.email("Delivery1@hotmail.com")

					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.password(passwordEncoder.encode("delivery"))

					.build();
			Usuario usuario5 = Usuario.builder()
					.auth0Id("User05")
					.username("Administrador1")
					.rol(Rol.Administrador)
//					.contraseña("Administrador1")
					.email("Administrador1@hotmail.com")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.password(passwordEncoder.encode("administrador"))

					.build();

			Usuario usuario6 = Usuario.builder()
					.auth0Id("User06")
					.username("Cocinero1")
					.rol(Rol.Cocinero)
//					.contraseña("Cocinero1")
					.email("user0404@outlook.com")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.password(passwordEncoder.encode("desarrollo"))

					.build();

			usuarioRepository.save(usuario1);
			usuarioRepository.save(usuario2);
			usuarioRepository.save(usuario3);
			usuarioRepository.save(usuario4);
			usuarioRepository.save(usuario5);
			usuarioRepository.save(usuario6);



			//VINCULAR DOMICILIO CON CLIENTE -----------------------------------------------

			cliente1.setDomicilio(domicilio1);
			cliente2.setDomicilio(domicilio2);

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			//VINCULAR DOMICILIO CON Empleado -----------------------------------------------

			empleado1.setDomicilio(domicilio3);
			empleado2.setDomicilio(domicilio4);
			empleado3.setDomicilio(domicilio5);
			empleado4.setDomicilio(domicilio6);

			empleadoRepository.save(empleado1);
			empleadoRepository.save(empleado2);
			empleadoRepository.save(empleado3);
			empleadoRepository.save(empleado4);

			//VINCULAR CLIENTE CON USUARIO -------------------------------------------------

			cliente1.setUsuario(usuario2);
			cliente2.setUsuario(usuario3);

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

		//VINCULAR EMPLEADO CON USUARIO -------------------------------------------------

			empleado1.setUsuario(usuario4);
			empleado2.setUsuario(usuario6);
			empleado3.setUsuario(usuario1);
			empleado4.setUsuario(usuario5);

			empleadoRepository.save(empleado1);
			empleadoRepository.save(empleado2);
			empleadoRepository.save(empleado3);
			empleadoRepository.save(empleado4);

			//CREAR ISNTANCIA DETALLE PEDIDO -----------------------------------------------

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(800)
					.subtotalCosto(500)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(6050)
					.subtotalCosto(5000)
					.build();


			//CREAR INSTANCIA DE PEDIDO ----------------------------------------------------

			Pedido pedido1 = Pedido.builder()
					.estado(EstadoPedido.Preparacion)
					.formaPago(FormaPago.Efectivo)
					.tipoEnvio(TipoEnvio.TakeAway)
					.total(600)
					.totalCosto(900)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaPedido(fecha)
					.horaEstimadaFinalizacion(fecha)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(EstadoPedido.Iniciado)
					.formaPago(FormaPago.TC)
					.tipoEnvio(TipoEnvio.Delivery)
					.total(800)
					.totalCosto(1000)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaPedido(fecha)
					.horaEstimadaFinalizacion(fecha)
					.build();


			//AGREGAR DETALLES AL PEDIDO ---------------------------------------------------

			pedido1.agregarDetallePedido(detallePedido1);
			pedido2.agregarDetallePedido(detallePedido2);

			//AGREGAR DOMICILIO AL PEDIDO --------------------------------------------------

			pedido1.setDomicilio(domicilio1);
			pedido2.setDomicilio(domicilio2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);


			//CREAR INSTANCIA DE MP --------------------------------------------------------

			MercadoPagoDatos mercadoPagoDatos1 = MercadoPagoDatos.builder()
					.estado("Pagado")
					.formaPago("Debito")
					.identificadorPago(8)
					.nroTarjeta("0880-989")
					.metodoPago("Bancario")
					.fechaAprobacion(fecha)
					.fechaCreacion(fecha)
					.build();
			MercadoPagoDatos mercadoPagoDatos2 = MercadoPagoDatos.builder()
					.estado("En transanccion")
					.formaPago("Debito")
					.identificadorPago(9)
					.nroTarjeta("0880-555")
					.metodoPago("Retiro en vantana")
					.fechaCreacion(fecha)
					.fechaAprobacion(fecha)
					.build();

			mercadoPagoDatosRepository.save(mercadoPagoDatos1);
			mercadoPagoDatosRepository.save(mercadoPagoDatos2);

			//AGREGAR EL MP AL PEDIDO -----------------------------------------------------

			pedido1.setMercadoPagoDatos(mercadoPagoDatos1);
			pedido2.setMercadoPagoDatos(mercadoPagoDatos2);
			//AGREGAR CLIENTES AL PEDIDO --------------------------------------------------

			pedido1.setCliente(cliente1);
			pedido2.setCliente(cliente2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);

			//CREAR DETALLE FACTURA -------------------------------------------------------

			DetalleFactura detalleFactura1 = DetalleFactura.builder()
					.cantidad(8)
					.subtotal(800)
					.build();
			DetalleFactura detalleFactura2 = DetalleFactura.builder()
					.cantidad(4)
					.subtotal(960)
					.build();
			DetalleFactura detalleFactura3 = DetalleFactura.builder()
					.cantidad(9)
					.subtotal(8000)
					.build();

			
			//CREAR INSTANCIAS FACTURA ----------------------------------------------------

			Factura factura1 = Factura.builder()
					.formaPago(FormaPago.TC)
					.mpMerchantOrderId(15)
					.mpPaymentId(3)
					.mpPreferenceId("MP568")
					.mpPaymentType("MP999")
					.totalVenta(8000)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaFacturacion(fecha)
					.build();

			Factura factura2 = Factura.builder()
					.formaPago(FormaPago.Efectivo)
					.mpMerchantOrderId(65)
					.mpPaymentId(37)
					.mpPreferenceId("MP998")
					.mpPaymentType("MP785")
					.totalVenta(10000)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaFacturacion(fecha)
					.build();

			//VINCULAR FACTURA CON DETALLE FACTURA

			factura1.agregarDetalleFactura(detalleFactura1);
			factura1.agregarDetalleFactura(detalleFactura2);
			factura2.agregarDetalleFactura(detalleFactura3);

			// VINCULAR FACTURA CON PEDIDO ------------------------------------------------

			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);


			// VINCULAR DETALLE PEDIDO CON LOS ARTICULOS -----------------------------------

			detallePedido1.setArticuloInsumo(articuloInsumo1);
			detallePedido1.setArticuloManufacturado(articuloManufacturado1);
			detallePedidoRepository.save(detallePedido1);

			detallePedido2.setArticuloManufacturado(articuloManufacturado2);
			detallePedido2.setArticuloInsumo(articuloInsumo2);
			detallePedidoRepository.save(detallePedido2);

			//VINCULAR DETALLEFACTURA CON LOS ARTICULOS -----------------------------------

			detalleFactura1.setArticuloInsumo(articuloInsumo1);
			detalleFactura1.setArticuloManufacturado(articuloManufacturado1);
			detalleFacturaRepository.save(detalleFactura1);

			detalleFactura2.setArticuloManufacturado(articuloManufacturado2);
			detalleFactura2.setArticuloInsumo(articuloInsumo2);
			detalleFacturaRepository.save(detalleFactura2);

			detalleFactura3.setArticuloInsumo(articuloInsumo2);
			detalleFactura3.setArticuloManufacturado(articuloManufacturado1);
			detalleFacturaRepository.save(detalleFactura3);

			//Vincular detalle art manuf con Art Insumo ------------------------------------

			detalleArticuloManufacturado1.setArticuloInsumo(articuloInsumo1);
			detalleArticuloManufacturado2.setArticuloInsumo(articuloInsumo2);



		};
	}
}