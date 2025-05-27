package io.github.devopMarkz.library_system.utils;

import io.github.devopMarkz.library_system.dtos.EscolaUpdateDTO;
import io.github.devopMarkz.library_system.dtos.endereco.EnderecoDTO;
import io.github.devopMarkz.library_system.dtos.escola.EscolaCreateDTO;
import io.github.devopMarkz.library_system.dtos.escola.EscolaResponseDTO;
import io.github.devopMarkz.library_system.model.Escola;
import io.github.devopMarkz.library_system.model.Endereco;
import io.github.devopMarkz.library_system.model.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class EscolaMapper {

    public Escola toEntity(EscolaCreateDTO dto) {
        if (dto == null) return null;

        Escola escola = new Escola();
        escola.setNome(dto.nome());
        escola.setCnpj(dto.cnpj());
        escola.setEndereco(toEnderecoEntity(dto.endereco()));
        if (dto.status() != null) {
            escola.setStatus(Status.valueOf(dto.status().toUpperCase()));
        }
        return escola;
    }

    public Escola toEntity(EscolaUpdateDTO dto) {
        if (dto == null) return null;

        Escola escola = new Escola();
        escola.setId(dto.id());
        escola.setNome(dto.nome());
        escola.setCnpj(dto.cnpj());
        escola.setEndereco(toEnderecoEntity(dto.endereco()));
        if (dto.status() != null) {
            escola.setStatus(Status.valueOf(dto.status().toUpperCase()));
        }
        return escola;
    }

    public EscolaResponseDTO toResponseDTO(Escola escola) {
        if (escola == null) return null;

        return new EscolaResponseDTO(
                escola.getId(),
                escola.getNome(),
                escola.getCnpj(),
                toEnderecoDTO(escola.getEndereco()),
                escola.getStatus()
        );
    }

    public Endereco toEnderecoEntity(EnderecoDTO dto) {
        if (dto == null) return null;

        Endereco endereco = new Endereco();
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setBairro(dto.bairro());
        endereco.setLocalidade(dto.localidade());
        endereco.setUf(dto.uf());
        endereco.setEstado(dto.estado());
        return endereco;
    }

    public EnderecoDTO toEnderecoDTO(Endereco endereco) {
        if (endereco == null) return null;

        return new EnderecoDTO(
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                endereco.getUf(),
                endereco.getEstado()
        );
    }
}
