package seguimiento.tallerhilos_sockets.interfazGrafica.util;

import seguimiento.tallerhilos_sockets.interfazGrafica.mapping.dto.EstudianteDto;

import java.util.function.Predicate;

public class EstudianteUtil {

    public static Predicate<EstudianteDto> buscarPorCodigo(String codigo){
        return estudianteDto -> estudianteDto.documento().contains(codigo);
    }

    public static Predicate<EstudianteDto> buscarPorNombres(String nombres){
        return estudianteDto -> estudianteDto.nombres().contains(nombres);
    }

    public static Predicate<EstudianteDto> buscarPorApellidos(String apellidos){
        return estudianteDto -> estudianteDto.apellidos().contains(apellidos);
    }

    public static Predicate<EstudianteDto> buscarPorEdad(String edad){
        return estudianteDto -> estudianteDto.edad().contains(edad);
    }

    public static Predicate<EstudianteDto> buscarPorOcupacion(String ocupacion){
        return estudianteDto -> estudianteDto.ocupacion().contains(ocupacion);
    }


    public static Predicate<EstudianteDto> buscarPorTodo(String documento, String nombres, String apellidos,
                                                         String edad, String ocupacion) {

        Predicate<EstudianteDto> predicado = estudianteDto -> true;

        if( documento != null && !documento.isEmpty() ){
            predicado = predicado.and(buscarPorCodigo(documento));
        }
        if( nombres != null && !nombres.isEmpty() ){
            predicado = predicado.and(buscarPorNombres(nombres));
        }
        if( apellidos != null && !apellidos.isEmpty() ){
            predicado = predicado.and(buscarPorApellidos(apellidos));
        }
        if( edad != null && !edad.isEmpty() ){
            predicado = predicado.and(buscarPorEdad(edad));
        }

        if( ocupacion != null && !ocupacion.isEmpty() ){
            predicado = predicado.and(buscarPorOcupacion(ocupacion));
        }

        return predicado;
    }
}
