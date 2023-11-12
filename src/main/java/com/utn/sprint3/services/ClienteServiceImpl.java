package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.dtos.DtoCliente;
import com.utn.sprint3.dtos.DtoMovimientosMonetarios;
import com.utn.sprint3.dtos.DtoRankingClientes;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{
@Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository){
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> search(String DatoCliente) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.search(DatoCliente);
            return clientes;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String DatoCliente, Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes = clienteRepository.searchNativo(DatoCliente, pageable);
            return clientes;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DtoCliente> findBy() {
        return clienteRepository.findBy();
    }


    @Override
    public List<DtoRankingClientes> rankingClientesPorCompras(String fecha1, String fecha2) throws Exception {
        try {
            List<Object[]> entities = clienteRepository.rankingClientesPorCompras(fecha1, fecha2);
            List<DtoRankingClientes> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                Long clienteId = (Long) entity[0];
                String nombreCliente = (String) entity[1];
                String otroCampo = (String) entity[2];

                // Utilizar BigDecimal directamente y formatearlos
                BigDecimal cantidadComprada = new BigDecimal(entity[3].toString());
                BigDecimal montoTotalComprado = new BigDecimal(entity[4].toString());

                // Formatear los valores con dos decimales
                cantidadComprada = cantidadComprada.setScale(2, RoundingMode.HALF_UP);
                montoTotalComprado = montoTotalComprado.setScale(2, RoundingMode.HALF_UP);

                DtoRankingClientes dto = new DtoRankingClientes(
                        clienteId,
                        nombreCliente,
                        otroCampo,
                        cantidadComprada,
                        montoTotalComprado
                );

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
