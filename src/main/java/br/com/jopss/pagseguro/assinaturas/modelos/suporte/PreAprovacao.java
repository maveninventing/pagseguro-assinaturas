package br.com.jopss.pagseguro.assinaturas.modelos.suporte;

import br.com.jopss.pagseguro.assinaturas.modelos.suporte.enums.PeriodoPreAprovacao;
import br.com.jopss.pagseguro.assinaturas.modelos.suporte.enums.TipoPreAprovacao;
import br.com.jopss.pagseguro.assinaturas.util.DateAdapterJaxB;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "preApproval")
public class PreAprovacao {
	
	/**
	 * Indica se a assinatura será gerenciada pelo PagSeguro (auto) ou pelo 
	 * Vendedor (manual). Neste caso usaremos o valor "auto". 
	 * 
	 * Opcional.
	 */
	@XmlElement(name = "charge")
	private TipoPreAprovacao tipo;
	
	/**
	 * Nome/Identificador da assinatura. 
	 * 
	 * Formato: 100 carac.
	 * Obrigatorio.
	 */
	@XmlElement(name = "name")
	private String nome;
	
	/**
	 * Detalhes/Descrição da assinatura. 
	 * 
	 * Formato: 255 carac.
	 * Opcional.
	 */
	@XmlElement(name = "details")
	private String descricao;
	
	/**
	 * Valor exato de cada cobrança. 
	 * Não pode ser utilizado em conjunto com 'maxAmountPerPayment.'
	 * 
	 * Formato: Decimal, com duas casas decimais separadas por ponto. Deve ser maior ou igual a 1.00 e menor ou igual a 1000000.00
	 * Obrigatório para o modelo automatico.
	 */
	@XmlElement(name = "amountPerPayment")
	private Double valorCobrancaPeriodica;
	
	/**
	 * Valor máximo de cada cobrança. 
	 * Não pode ser utilizado em conjunto com 'amountPerPayment.'
	 * 
	 * Formato: Decimal, com duas casas decimais separadas por ponto. Deve ser maior ou igual a 1.00 e menor ou igual a 1000000.00
	 * Opcional.
	 */
	@XmlElement(name = "maxAmountPerPayment")
	private Double valorMaximoCobrancaPeriodica;
	
	/**
	 * Periodicidade da cobrança.
	 * 
	 * Obrigatório.
	 */
	@XmlElement(name = "period")
	private PeriodoPreAprovacao periodo;
	
	/**
	 * Número máximo de cobranças que podem ser realizadas por período. 
	 * 
	 * Formato: Inteiro, maior ou igual a 1 e menor ou igual a 1000000
	 * Opcional, podendo ser utilizado apenas quando a assinatura é gerenciada pelo vendedor (charge = manual). 
	 */
	@XmlElement(name = "maxPaymentsPerPeriod")
	private Integer limiteCobrancasPorPeriodo;
	
	/**
	 * Valor máximo que pode ser cobrado por mês de vigência da assinatura, independente de sua periodicidade. 
	 * 
	 * Formato: Decimal, com duas casas decimais separadas por ponto. Deve ser maior ou igual a 1.00 e menor ou igual a 2000.00.
	 * Obrigatória quando a assinatura é gerenciada pelo vendedor (charge = manual). Não é utilizada quando a assinatura é gerenciada pelo PagSeguro (charge = auto).
	 */
	@XmlElement(name = "maxAmountPerPeriod")
	private Double valorLimiteMensal;
	
	/**
	 * Início da vigência da assinatura. 
	 * Assume valores maiores que a data atual e menores ou iguais a data atual + 2 anos. 
	 * 
	 * Formato: Data/Hora, YYYY-MM-DDThh:mm:ss.sTZD.
	 * Obrigatória.
	 */
	@XmlElement(name = "initialDate")
	@XmlJavaTypeAdapter(DateAdapterJaxB.class)
	private Date dataInicioCobranca;
	
	/**
	 * Fim da vigência da assinatura. 
	 * Assume valores maiores que a data atual ou maiores que o valor definido em 'initialDate', não podendo ter uma diferença superior a 2 anos da data de início.
	 * 
	 * Formato: Data/Hora, YYYY-MM-DDThh:mm:ss.sTZD.
	 * Obrigatória.
	 */
	@XmlElement(name = "finalDate")
	@XmlJavaTypeAdapter(DateAdapterJaxB.class)
	private Date dataFinalCobranca;
	
	/**
	 * Valor máximo que pode ser cobrado durante a vigência da assinatura. 
	 * 
	 * Formato: Decimal, com duas casas decimais separadas por ponto. Deve ser maior ou igual a 1.00 e menor ou igual a 35000.00 
	 * Obrigatória.
	 */
	@XmlElement(name = "maxTotalAmount")
	private Double limiteValorAssinatura;

	public PreAprovacao() {
	}
	
	public PreAprovacao(String nome, PeriodoPreAprovacao periodo, Date dataInicioCobranca, Date dataFinalCobranca, Double limiteValorAssinatura, Double valorLimiteMensal) {
		this.periodo = periodo;
		this.dataInicioCobranca = dataInicioCobranca;
		this.dataFinalCobranca = dataFinalCobranca;
		this.limiteValorAssinatura = limiteValorAssinatura;
		this.valorLimiteMensal = valorLimiteMensal;
		this.nome = nome;
	}

	public void setTipo(TipoPreAprovacao tipo) {
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorCobrancaPeriodica(Double valorCobrancaPeriodica) {
		this.valorCobrancaPeriodica = valorCobrancaPeriodica;
	}

	public void setValorMaximoCobrancaPeriodica(Double valorMaximoCobrancaPeriodica) {
		this.valorMaximoCobrancaPeriodica = valorMaximoCobrancaPeriodica;
	}

	public void setLimiteCobrancasPorPeriodo(Integer limiteCobrancasPorPeriodo) {
		this.limiteCobrancasPorPeriodo = limiteCobrancasPorPeriodo;
	}

	public void setValorLimiteMensal(Double valorLimiteMensal) {
		this.valorLimiteMensal = valorLimiteMensal;
	}
	
}