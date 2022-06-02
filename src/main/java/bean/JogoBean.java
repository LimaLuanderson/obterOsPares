/*
 * 	j)  [2,0 pt] Criar a classe JogoBean, essa classe deve
	permitir a comunicação entre as páginas criadas nos itens
	“e” e “f” viabilizando o salvamento (0,25 pt), edição(0,25 pt),
	exclusão(0,25 pt), listagem das entidades (0,25 pt) e exibição 
	do resultado do item “i” (1,0 pt).
*/

package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entidade.Jogo;

@ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private List<Jogo> listaJogo;
	private List<String> listaPares;

	public String salvar() {
		try {
			jogo.gerarNumerosAleatorios();
			JogoDAO.salvar(jogo);
			jogo = new Jogo();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Salvo com successo!"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao Salvar!", "Os dados não foram salvos!"));
		}

		return null;
	}

	public String gerarOsPares() {
		jogo.obterOsPares();
		return null;
	}

	public String editar() {
		try {
			jogo.gerarNumerosAleatorios();
			JogoDAO.editar(jogo);
			jogo = new Jogo();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Editado com successo!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao Editar!", "Os dados não foram editados!"));
		}

		return null;
	}

	public String excluir() {
		try {
			JogoDAO.deletar(jogo);
			listaJogo.remove(jogo);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Excluído com successo!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Falha ao Excluir!", "Os dados não foram excluídos!"));
		}

		return null;
	}

	public String listar() {
		listaJogo = JogoDAO.listar();
		return "listagem";
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getListaJogo() {
		if (listaJogo == null) {
			listaJogo = JogoDAO.listar();
		}

		return listaJogo;
	}

	public void setListaJogo(List<Jogo> listaJogo) {
		this.listaJogo = listaJogo;
	}

	public List<String> getListaPares() {
		return listaPares;
	}

	public void setListaPares(List<String> listaPares) {
		this.listaPares = listaPares;
	}

}
