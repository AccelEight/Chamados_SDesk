package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

/**
 * 
 * @author Accel Gustavo Araujo Rocha RA 81616654 SI3AN-MCA
 *
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;

	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService) {
		this.filaService = filaService;
		this.chamadoService = chamadoService;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	@RequestMapping("/tela_inicio")
	public String inicio2() {
		return "TelaPrincipal";
	}

	@Transactional
	private List<Fila> listarFilas() throws IOException {
		return filaService.listarFilas();
	}

	@Transactional

	private List<Chamado> listarChamados(Fila fila) throws IOException {
		return chamadoService.listarChamados(fila);
	}

	@Transactional
	private void cadastrarChamado(String desc, Fila fila) throws IOException {
		Chamado c = new Chamado();
		Date d = new Date();
		c.setDescricao(desc);
		c.setFila(fila);
		c.setStatus("aberto");
		c.setDt_abertura(d);
		chamadoService.cadastrarChamado(c);
	}

	/**
	 * 
	 * @param model
	 *            Acesso Ã request http
	 * @return JSP de Listar Chamados
	 */
	@Transactional
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	/**
	 * 
	 * @param model
	 *            lista as filas para cadastro do chamado
	 * @return JSP de cadastro
	 */
	@Transactional
	@RequestMapping("/cadastrar_chamado")
	public String cadastrarChamado(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "CadastrarChamado";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	/**
	 * 
	 * @param desc
	 *            descrição do chamado
	 * @param fila
	 *            do chamado a ser cadastrado
	 * @return JSP para informar o cadastro
	 */
	@Transactional
	@RequestMapping("/chamado_cadastrado")
	public String chamadoCadastrado(String desc, Fila fila) {
		try {
			cadastrarChamado(desc, fila);
			return "ChamadoCadastrado";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	/**
	 * 
	 * @param fila
	 *            lista de filas
	 * @param result
	 *            resultado da requisição
	 * @param model
	 *            parametros
	 * @return JSP de chamados
	 */
	@Transactional
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				// return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("chamados", listarChamados(fila));

			return "ChamadoListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}